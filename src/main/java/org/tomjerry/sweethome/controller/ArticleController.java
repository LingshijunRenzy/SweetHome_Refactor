package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.response.Result;

import java.util.List;

public interface ArticleController {
    Result<ArticleEntity> getArticleById(int id);
    Result<List<ArticleEntity>> getArticlesByKeyWord(String keyword);
    Result<List<ArticleEntity>> getArticlesByUserId(int userId);
    Result<List<ArticleEntity>> getArticlesByTitle(String title);
    Result<List<ArticleEntity>> getArticlesByContent(String content);
    Result<List<ArticleEntity>> getAllArticles();
    Result<ArticleEntity> addArticle(ArticleEntity article);
    Result<ArticleEntity> updateArticle(ArticleEntity article);
    Result<String> deleteArticle(int id);
}
