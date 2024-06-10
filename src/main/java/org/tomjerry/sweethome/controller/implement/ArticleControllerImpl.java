package org.tomjerry.sweethome.controller.implement;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.ArticleController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.vo.request.AddArticleRequest;
import org.tomjerry.sweethome.vo.response.Result;
import org.tomjerry.sweethome.service.ArticleService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }



    @Override
    @GetMapping("/{id}")
    public Result<ArticleEntity> getArticleById(@PathVariable Integer id) {

        ArticleEntity article = articleService.getArticleById(id);


        if (article != null) {
            return new Result<>(200, "Get article success", article);
        } else {
            return new Result<>(404, "Article not found", null);
        }
    }



    @Override
    @GetMapping
    public Result<Page<ArticleEntity>> getArticlesByUserId(
            @RequestParam Integer userId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<ArticleEntity> articlePage = articleService.getArticlesByUserId(userId, page, size);

        return new Result<>(200, "Get articles success", articlePage);
    }



    @Override
    @PostMapping
    public Result<ArticleEntity> addArticle(
            @RequestAttribute Integer userId,
            @RequestBody AddArticleRequest addArticleRequest) {

        String title = addArticleRequest.getTitle();
        String content = addArticleRequest.getContent();

        ArticleEntity article = articleService.addArticle(title, content, userId);


        if (article != null) {
            return new Result<>(200, "Add article success", article);
        } else {
            return new Result<>(400, "Add article failed", null);
        }
    }

    @Override
    @PatchMapping("/{articleId}")
    public Result<ArticleEntity> updateArticle(
            @RequestAttribute Integer userId,
            @PathVariable Integer articleId,
            @RequestBody Map<String, Object> updates) {

        boolean success = articleService.updateArticle(articleId, updates);


        if(success) {
            return new Result<>(200, "Update article success", articleService.getArticleById(articleId));
        }else{
            return new Result<>(400, "Update article failed", null);
        }

    }



    @Override
    @DeleteMapping("/{id}")
    public Result<String> deleteArticle(@PathVariable int id) {
        boolean success = articleService.deleteArticle(id);


        if (success) {
            return new Result<>(200, "Delete article success", null);
        } else {
            return new Result<>(400, "Delete article failed", null);
        }
    }



    @Override
    @PostMapping("/test")
    public String JwtAuthenticationFilterTest(@RequestAttribute Integer userId) {
        return "Test: UserId = " + userId + " passed the authentication.";
    }
}