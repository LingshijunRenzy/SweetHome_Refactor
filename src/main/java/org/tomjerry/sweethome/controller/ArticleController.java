package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.vo.request.AddArticleRequest;
import org.tomjerry.sweethome.vo.response.Result;

import java.util.List;
import java.util.Map;

public interface ArticleController {


    Result<ArticleEntity> getArticleById(Integer id);


    Result<List<ArticleEntity>> getArticlesByUserId(Integer userId);


    Result<ArticleEntity> addArticle(Integer userId, AddArticleRequest addArticleRequest);


    Result<ArticleEntity> updateArticle(Integer userId, Integer articleId, Map<String, Object> updates);


    Result<String> deleteArticle(int id);


    String JwtAuthenticationFilterTest(Integer userId);
}
