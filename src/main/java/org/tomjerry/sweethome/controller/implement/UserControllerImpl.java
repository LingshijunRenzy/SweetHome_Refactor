package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.UserController;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.vo.request.LoginRequest;
import org.tomjerry.sweethome.vo.request.RegisterRequest;
import org.tomjerry.sweethome.vo.response.LoginResponse;
import org.tomjerry.sweethome.vo.response.Result;
import org.tomjerry.sweethome.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }



    @Override
    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        String loginContext = loginRequest.getLoginContext();
        String password = loginRequest.getPassword();

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
    public Result<LoginResponse> register(@RequestBody RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        String email = registerRequest.getEmail();
        String phone = registerRequest.getPhone();
        String password = registerRequest.getPassword();

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



    @Override
    @GetMapping("/info")
    public Result<UserEntity> getUserById(@RequestAttribute Integer userId) {
        Result<UserEntity> result = new Result<>();
        UserEntity user = userService.getUserById(userId);

        if (user != null) {
            result.setCode(200);
            result.setMessage("Get user success");
            result.setData(user);
        } else {
            result.setCode(404);
            result.setMessage("User not found");
        }

        return result;
    }



    @Override
    @DeleteMapping("/info")
    public Result<String> deleteUserById(@RequestAttribute Integer userId) {
        Result<String> result = new Result<>();
        boolean success = userService.deleteUser(userId);

        if (success) {
            result.setCode(200);
            result.setMessage("Delete user success");
        } else {
            result.setCode(400);
            result.setMessage("Delete user failed");
        }

        return result;
    }



    @Override
    @PatchMapping("/info")
    public Result<UserEntity> updateUser(@RequestAttribute Integer userId,@RequestBody Map<String, Object> updates) {
        Result<UserEntity> result = new Result<>();
        boolean success = userService.updateUser(userId, updates);

        if (success) {
            result.setCode(200);
            result.setMessage("Update user success");
            result.setData(userService.getUserById(userId));
        } else {
            result.setCode(400);
            result.setMessage("Update user failed");
        }

        return result;
    }
}
