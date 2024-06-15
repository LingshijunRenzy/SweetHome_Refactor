package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.AdminController;
import org.tomjerry.sweethome.service.ArticleService;
import org.tomjerry.sweethome.service.UserService;
import org.tomjerry.sweethome.vo.response.Result;

@RestController
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    private final UserService userService;
    private final ArticleService articleService;

    public AdminControllerImpl(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }



    @Override
    @PostMapping("/refresh/user")
    public Result<String> refreshUserInfo() {
        userService.refreshUserInfo();
        return new Result<>(200, "OK", "user info refresh success");
    }



    @Override
    @PostMapping("/refresh/article")
    public Result<String> refreshArticleInfo() {
        articleService.refreshArticleInfo();
        return new Result<>(200, "OK", "article info refresh success");
    }



    @Override
    @PostMapping("/test")
    public Result<String> testAdminConnection(@RequestAttribute Integer userId) {
        return new Result<>(200, "OK", "admin connection success, userID = " + userId.toString());
    }
}
