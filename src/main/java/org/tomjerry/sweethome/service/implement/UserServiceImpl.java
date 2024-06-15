package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.*;
import org.tomjerry.sweethome.vo.response.LoginResponse;
import org.tomjerry.sweethome.service.UserService;
import org.tomjerry.sweethome.util.token.TokenService;
import org.tomjerry.sweethome.vo.response.UserResponse;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final FollowRepository followRepository;
    private final TokenService tokenService;



    public UserServiceImpl(
            UserRepository userRepository,
            TokenService tokenService,
            ArticleRepository articleRepository,
            CommentRepository commentRepository,
            LikeRepository likeRepository,
            FollowRepository followRepository) {

        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.followRepository = followRepository;
    }



    @Override
    public void addUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public boolean updateUser(UserEntity user) {
        userRepository.save(user);
        return true;
    }



    @Override
    public boolean updateUser(int id, Map<String, Object> updates) {

        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(UserEntity.class, key);
            if (field == null) {
                throw new RuntimeException("Field not found");
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, value);

        });

        //设置更新时间
        user.setUpdate_time(new Timestamp(System.currentTimeMillis()));

        userRepository.save(user);
        return true;
    }



    @Override
    public boolean deleteUser(int id) {

        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
        return true;
    }



    @Override
    public UserEntity getUserById(int id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }



    public UserEntity getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }



    public UserEntity getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }



    public UserEntity getUserByPhoneAndPassword(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone, password);
    }



    @Override
    public LoginResponse login(String loginContext, String password) {

        UserEntity user;

        if (loginContext.contains("@")) {
            user = getUserByEmailAndPassword(loginContext, password);

            if(user == null){
                throw new RuntimeException("email or password is incorrect");
            }

        } else {
            user = getUserByPhoneAndPassword(loginContext, password);

            if(user == null){
                throw new RuntimeException("phone or password is incorrect");
            }

        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(new UserResponse(user));
        loginResponse.setToken(tokenService.generateToken(user.getId()));

        return loginResponse;
    }



    @Override
    public LoginResponse register(String username, String email, String phone, String password) {

        //check if email or phone already exists
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email already exists");
        }

        if(userRepository.existsByPhone(phone)){
            throw new RuntimeException("Phone already exists");
        }

        //check if params are invalid
        if(username == null || username.length() < 3 || username.length() > 20){
            throw new RuntimeException("Username length must be between 3 and 20");
        }

        if(email == null || email.length() < 5 || email.length() > 50){
            throw new RuntimeException("Email length must be between 5 and 50");
        }

        if(phone == null || phone.length() != 11){
            throw new RuntimeException("Phone length must be 11");
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        addUser(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(new UserResponse(user));
        loginResponse.setToken(tokenService.generateToken(user.getId()));
        return loginResponse;
    }



    @Override
    public boolean refreshUserInfo() {
        userRepository.findAll().forEach(user -> {
            //Recalculate user article count
            user.setArticle_count(articleRepository.countByUserid(user.getId()));

            //Recalculate user comment count
            user.setComment_count(commentRepository.countByUserId(user.getId()));

            //Recalculate user like count
            user.setLiked_count(likeRepository.countByUserId(user.getId()));

            //Recalculate user follow count
            user.setFollow_count(followRepository.countByUserId(user.getId()));

            //Recalculate user fans count
            user.setFans_count(followRepository.countByFollowUserId(user.getId()));

            userRepository.save(user);

            //控制台日志
            System.out.println("User " + user.getId() + " info refreshed");
        });
        return true;
    }
}
