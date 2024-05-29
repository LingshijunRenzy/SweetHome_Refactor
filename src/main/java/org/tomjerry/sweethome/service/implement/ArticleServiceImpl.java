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
        ArticleEntity articleEntity = articleRepository.findById(id).orElse(null);
        return articleEntity;
    }

    @Override
    public List<ArticleEntity> getArticlesByTitle(String title) {
        List<ArticleEntity> articleEntities = articleRepository.findByTitleContaining(title);
        return articleEntities;
    }

    @Override
    public List<ArticleEntity> getArticlesByContent(String content) {
        List<ArticleEntity> articleEntities = articleRepository.findByContentContaining(content);
        return articleEntities;
    }

    @Override
    public List<ArticleEntity> getArticlesByKeyword(String keyword) {
        List<ArticleEntity> articleEntities = articleRepository.findByTitleContaining(keyword);
        articleEntities.addAll(articleRepository.findByContentContaining(keyword));
        return articleEntities;
    }

    @Override
    public List<ArticleEntity> getArticlesByUserId(int userId) {
        List<ArticleEntity> articleEntities = articleRepository.findByUserid(userId);
        return articleEntities;
    }

    @Override
    public List<ArticleEntity> getAllArticles() {
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        return articleEntities;
    }
}
