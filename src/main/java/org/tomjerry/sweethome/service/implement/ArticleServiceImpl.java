package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void addArticle(ArticleEntity article) {
        articleRepository.save(article);
    }

    public ArticleEntity addArticle(String title, String content, int userId) {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(title);
        article.setContent(content);
        article.setUserid(userId);
        articleRepository.save(article);
        return article;
    }

    @Override
    public void updateArticle(ArticleEntity article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleEntity getArticleById(int id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public List<ArticleEntity> getArticlesByTitle(String title) {
        return articleRepository.findByTitleContaining(title);
    }

    @Override
    public List<ArticleEntity> getArticlesByContent(String content) {
        return articleRepository.findByContentContaining(content);
    }

    @Override
    public List<ArticleEntity> getArticlesByKeyword(String keyword) {
        List<ArticleEntity> articleEntities = articleRepository.findByTitleContaining(keyword);
        articleEntities.addAll(articleRepository.findByContentContaining(keyword));
        return articleEntities;
    }

    @Override
    public List<ArticleEntity> getArticlesByUserId(int userId) {
        return articleRepository.findByUserid(userId);
    }

    @Override
    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }
}
