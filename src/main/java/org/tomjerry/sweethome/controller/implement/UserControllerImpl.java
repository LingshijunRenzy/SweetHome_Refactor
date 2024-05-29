package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.UserController;
import org.tomjerry.sweethome.response.LoginResponse;
import org.tomjerry.sweethome.response.Result;
import org.tomjerry.sweethome.service.UserService;
import org.tomjerry.sweethome.util.token.TokenService;

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

        Result<LoginResponse> result = new Result<>();
        LoginResponse loginResponse = userService.login(loginContext, password);

        if (loginResponse != null) {
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

        Result<LoginResponse> result = new Result<>();
        LoginResponse loginResponse = userService.register(username, email, phone, password);

        if (loginResponse != null) {
            result.setCode(200);
            result.setMessage("Register success");
            result.setData(loginResponse);
        } else {
            result.setCode(400);
            result.setMessage("Register failed");
        }

        return result;
    }
}
