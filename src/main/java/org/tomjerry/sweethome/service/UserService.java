package org.tomjerry.sweethome.service;


import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.response.LoginResponse;

public interface UserService {
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(int id);
    UserEntity getUserById(int id);
    UserEntity getUserByUsernameAndPassword(String username, String password);
    UserEntity getUserByEmailAndPassword(String email, String password);
    UserEntity getUserByPhoneAndPassword(String phone, String password);

    LoginResponse login(String loginContext, String password);
    LoginResponse register(String username, String email, String phone, String password);
}
