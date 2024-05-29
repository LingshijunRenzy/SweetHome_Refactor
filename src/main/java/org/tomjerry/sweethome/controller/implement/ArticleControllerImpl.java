package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.ArticleController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
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
    public Result<ArticleEntity> getArticleById(int id) {
        return null;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByKeyWord(String keyword) {
        return null;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByUserId(int userId) {
        return null;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByTitle(String title) {
        return null;
    }

    @Override
    public Result<List<ArticleEntity>> getArticlesByContent(String content) {
        return null;
    }

    @Override
    public Result<List<ArticleEntity>> getAllArticles() {
        return null;
    }

    @Override
    @PostMapping("/add")
    public Result<ArticleEntity> addArticle(ArticleEntity article) {
        articleService.addArticle(article);
        return new Result<>(200, "Add article success", article);
    }

    @Override
    public Result<ArticleEntity> updateArticle(ArticleEntity article) {
        return null;
    }

    @Override
    public Result<String> deleteArticle(int id) {
        return null;
    }
}