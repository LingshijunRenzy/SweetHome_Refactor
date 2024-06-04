package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.tomjerry.sweethome.dao.implement.UserDaoImpl;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.response.LoginResponse;
import org.tomjerry.sweethome.service.UserService;
import org.tomjerry.sweethome.util.token.TokenService;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final TokenService tokenService;

    public UserServiceImpl(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
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
            return false;
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(UserEntity.class, key);
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, value);

        });

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return userEntity;
    }

    public UserEntity getUserByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);
        return userEntity;
    }

    public UserEntity getUserByEmailAndPassword(String email, String password) {
        UserEntity userEntity = userRepository.findByEmailAndPassword(email, password);
        return userEntity;
    }

    public UserEntity getUserByPhoneAndPassword(String phone, String password) {
        UserEntity userEntity = userRepository.findByPhoneAndPassword(phone, password);
        return userEntity;
    }

    @Override
    public LoginResponse login(String loginContext, String password) {
        UserEntity user;
        if (loginContext.contains("@")) {
            user = getUserByEmailAndPassword(loginContext, password);
        } else {
            user = getUserByPhoneAndPassword(loginContext, password);
        }
        LoginResponse loginResponse = new LoginResponse();
        if (user != null) {
            loginResponse.setUser(user);
            loginResponse.setToken(tokenService.generateToken(user.getId()));
        }
        return loginResponse;
    }

    @Override
    public LoginResponse register(String username, String email, String phone, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        addUser(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(user);
        loginResponse.setToken(tokenService.generateToken(user.getId()));
        return loginResponse;
    }
}
