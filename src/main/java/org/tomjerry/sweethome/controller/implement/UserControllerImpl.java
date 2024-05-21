package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.UserController;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.response.LoginResponse;
import org.tomjerry.sweethome.response.Result;
import org.tomjerry.sweethome.service.UserService;

@RestController
public class UserControllerImpl implements UserController{

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/login")
    public Result<LoginResponse> login(
            @RequestParam("loginContext") String loginContext,
            @RequestParam("password") String password) {

        UserEntity user;

        //user can log in with email or phone number
        //if loginContext contains "@" then it is an email
        if (loginContext.contains("@")) {
            user = userService.getUserByEmailAndPassword(loginContext, password);
        //if loginContext contains only numbers then it is a phone number
        } else {
            user = userService.getUserByPhoneAndPassword(loginContext, password);
        }

        Result<LoginResponse> result = new Result<>();
        if (user != null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUser(user);
            loginResponse.setToken("token");
            result.setCode(200);
            result.setMessage("Login success");
            result.setData(loginResponse);
        } else {
            result.setCode(400);
            result.setMessage("Login failed");
        }

        return result;
    }

    @Override
    @PostMapping("/register")
    public Result<LoginResponse> register(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password) {

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        userService.addUser(user);

        Result<LoginResponse> result = new Result<>();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(user);
        loginResponse.setToken("token");
        result.setCode(200);
        result.setMessage("Register success");
        result.setData(loginResponse);

        return result;
    }
}
