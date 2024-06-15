package org.tomjerry.sweethome.service;


import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.vo.response.LoginResponse;

import java.util.Map;

public interface UserService {
    void addUser(UserEntity user);
    boolean updateUser(UserEntity user);
    boolean updateUser(int id, Map<String,Object> updates);
    boolean deleteUser(int id);
    UserEntity getUserById(int id);
    UserEntity getUserByUsernameAndPassword(String username, String password);
    UserEntity getUserByEmailAndPassword(String email, String password);
    UserEntity getUserByPhoneAndPassword(String phone, String password);

    LoginResponse login(String loginContext, String password);
    LoginResponse register(String username, String email, String phone, String password);

    boolean refreshUserInfo();
}
