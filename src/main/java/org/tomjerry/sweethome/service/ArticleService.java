package org.tomjerry.sweethome.service;

import org.springframework.data.domain.Page;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;

import java.util.Map;

public interface ArticleService {
    ArticleEntity addArticle(String title, String content, int userId);
    boolean updateArticle(Integer id, Map<String, Object> updates);
    boolean deleteArticle(Integer id);

    ArticleEntity getArticleById(int id);

    Page<ArticleEntity> getArticlesByUserId(int userId, int page, int size);
}
