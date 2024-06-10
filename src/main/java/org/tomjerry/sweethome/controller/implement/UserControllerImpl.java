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

        LoginResponse loginResponse = userService.login(
                loginRequest.getLoginContext(),
                loginRequest.getPassword());

        return new Result<>(200, "Login success", loginResponse);
    }



    @Override
    @PostMapping("/register")
    public Result<LoginResponse> register(@RequestBody RegisterRequest registerRequest) {
        LoginResponse loginResponse = userService.register(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPhone(),
                registerRequest.getPassword());

        return new Result<>(200, "Register success", loginResponse);
    }



    @Override
    @GetMapping("/info/{id}")
    public Result<UserEntity> getUserById(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);

        return new Result<>(200, "Get user success", user);
    }



    @Override
    @DeleteMapping("/info")
    public Result<String> deleteUserById(@RequestAttribute Integer userId) {
        userService.deleteUser(userId);

        return new Result<>(200, "Delete user success", null);
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
