package org.tomjerry.sweethome.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.request.AddArticleRequest;
import org.tomjerry.sweethome.response.Result;

import java.util.List;

public interface ArticleController {
    Result<ArticleEntity> getArticleById(Integer id);
    Result<List<ArticleEntity>> getArticlesByKeyWord(String keyword);
    Result<List<ArticleEntity>> getArticlesByUserId(Integer userId);
    Result<List<ArticleEntity>> getArticlesByTitle(String title);
    Result<List<ArticleEntity>> getArticlesByContent(String content);
    Result<ArticleEntity> addArticle(AddArticleRequest addArticleRequest, Integer userId);
    Result<ArticleEntity> updateArticle(ArticleEntity article);
    Result<String> deleteArticle(int id);

    String JwtAuthenticationFilterTest(Integer userId);
}
