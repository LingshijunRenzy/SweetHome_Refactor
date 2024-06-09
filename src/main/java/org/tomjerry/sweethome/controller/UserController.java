package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.vo.request.LoginRequest;
import org.tomjerry.sweethome.vo.request.RegisterRequest;
import org.tomjerry.sweethome.vo.response.LoginResponse;
import org.tomjerry.sweethome.vo.response.Result;

import java.util.Map;

public interface UserController {

    Result<LoginResponse> login(LoginRequest loginRequest);



    Result<LoginResponse> register(RegisterRequest registerRequest);


    Result<UserEntity> getUserById(Integer userId);


    Result<String> deleteUserById(Integer userId);


    Result<UserEntity> updateUser(Integer userId, Map<String, Object> updates);
}