package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.response.LoginResponse;
import org.tomjerry.sweethome.response.Result;

public interface UserController {
    Result<LoginResponse> login(String loginContext, String password);
    Result<LoginResponse> register(String username, String email, String phone, String password);
}