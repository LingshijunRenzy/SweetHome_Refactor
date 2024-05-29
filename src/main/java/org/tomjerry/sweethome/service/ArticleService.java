package org.tomjerry.sweethome.service;

import org.tomjerry.sweethome.pojo.entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    void addArticle(ArticleEntity article);
    void updateArticle(ArticleEntity article);
    void deleteArticle(int id);

    ArticleEntity getArticleById(int id);
    List<ArticleEntity> getArticlesByTitle(String title);
    List<ArticleEntity> getArticlesByContent(String content);
    List<ArticleEntity> getArticlesByKeyword(String keyword);
    List<ArticleEntity> getArticlesByUserId(int userId);
    List<ArticleEntity> getAllArticles();
}
