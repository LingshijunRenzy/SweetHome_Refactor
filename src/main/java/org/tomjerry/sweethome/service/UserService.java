package org.tomjerry.sweethome.service;


import org.tomjerry.sweethome.pojo.entity.UserEntity;

public interface UserService {
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(int id);
    UserEntity getUserById(int id);
}
