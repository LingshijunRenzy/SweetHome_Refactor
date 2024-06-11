package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.AdminController;
import org.tomjerry.sweethome.service.UserService;
import org.tomjerry.sweethome.vo.response.Result;

@RestController
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    private final UserService userService;

    public AdminControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Result<String> login(String email, String password) {
        return null;
    }



    @Override
    @PostMapping("/refresh/user")
    public Result<String> refreshUserInfo() {
        return null;
    }



    @Override
    @PostMapping("/refresh/article")
    public Result<String> refreshArticleInfo() {
        return null;
    }
}
