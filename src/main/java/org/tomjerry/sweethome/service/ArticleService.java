package org.tomjerry.sweethome.service;

import org.tomjerry.sweethome.pojo.entity.ArticleEntity;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    ArticleEntity addArticle(String title, String content, int userId);
    boolean updateArticle(Integer id, Map<String, Object> updates);
    boolean deleteArticle(Integer id);

    ArticleEntity getArticleById(int id);
    List<ArticleEntity> getArticlesByUserId(int userId);
}
