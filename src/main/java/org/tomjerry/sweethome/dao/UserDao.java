package org.tomjerry.sweethome.dao;

import org.tomjerry.sweethome.pojo.entity.UserEntity;

public interface UserDao{
    public UserEntity getUserById(int id);
    public UserEntity getUserByName(String name);
    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public void deleteUser(int id);
}
