package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.ArticleController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.request.AddArticleRequest;
import org.tomjerry.sweethome.response.Result;
import org.tomjerry.sweethome.service.ArticleService;

import java.util.List;

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
        Result<ArticleEntity> result = new Result<>();
        ArticleEntity article = articleService.getArticleById(id);
        if (article != null) {
            result.setCode(200);
            result.setMessage("Get article success");
            result.setData(article);
        } else {
            result.setCode(404);
            result.setMessage("Article not found");
        }
        return result;
    }

    @Override
    @GetMapping("/search")
    public Result<List<ArticleEntity>> getArticlesByKeyWord(@RequestParam String keyword) {
        Result<List<ArticleEntity>> result = new Result<>();
        List<ArticleEntity> articles = articleService.getArticlesByKeyword(keyword);
        if (articles != null) {
            result.setCode(200);
            result.setMessage("Get articles success");
            result.setData(articles);
        } else {
            result.setCode(404);
            result.setMessage("Articles not found");
        }
        return result;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByUserId(@RequestParam Integer userId) {
        Result<List<ArticleEntity>> result = new Result<>();
        List<ArticleEntity> articles = articleService.getArticlesByUserId(userId);
        if (articles != null) {
            result.setCode(200);
            result.setMessage("Get articles success");
            result.setData(articles);
        } else {
            result.setCode(404);
            result.setMessage("Articles not found");
        }
        return result;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByTitle(@RequestParam String title) {
        Result<List<ArticleEntity>> result = new Result<>();
        List<ArticleEntity> articles = articleService.getArticlesByTitle(title);
        if (articles != null) {
            result.setCode(200);
            result.setMessage("Get articles success");
            result.setData(articles);
        } else {
            result.setCode(404);
            result.setMessage("Articles not found");
        }
        return result;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByContent(@RequestParam String content) {
        Result<List<ArticleEntity>> result = new Result<>();
        List<ArticleEntity> articles = articleService.getArticlesByContent(content);
        if (articles != null) {
            result.setCode(200);
            result.setMessage("Get articles success");
            result.setData(articles);
        } else {
            result.setCode(404);
            result.setMessage("Articles not found");
        }
        return result;
    }

    @Override
    @PostMapping("/add")
    public Result<ArticleEntity> addArticle(
            @RequestBody AddArticleRequest addArticleRequest,
            @RequestAttribute Integer userId) {

        String title = addArticleRequest.getTitle();
        String content = addArticleRequest.getContent();

        ArticleEntity article = articleService.addArticle(title, content, userId);
        Result<ArticleEntity> result = new Result<>();
        if (article != null) {
            result.setCode(200);
            result.setMessage("Add article success");
            result.setData(article);
        } else {
            result.setCode(500);
            result.setMessage("Add article failed");
        }
        return result;
    }

    @Override
    public Result<ArticleEntity> updateArticle(ArticleEntity article) {
        return null;
    }

    @Override
    public Result<String> deleteArticle(int id) {
        return null;
    }

    @Override
    @PostMapping("/test")
    public String JwtAuthenticationFilterTest(@RequestAttribute Integer userId) {
        return "Test: UserId = " + userId + " passed the authentication.";
    }
}