package org.tomjerry.sweethome.service;


import org.tomjerry.sweethome.pojo.entity.UserEntity;

public interface UserService {
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(int id);
    UserEntity getUserById(int id);
    UserEntity getUserByUsernameAndPassword(String username, String password);
    UserEntity getUserByEmailAndPassword(String email, String password);
    UserEntity getUserByPhoneAndPassword(String phone, String password);
}
