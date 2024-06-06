package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.service.ArticleService;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
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
    public boolean updateArticle(Integer id, Map<String, Object> updates) {

        ArticleEntity article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            return false;
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(UserEntity.class, key);
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, article, value);

        });

        //设置更新时间
        article.setUpdate_time(new Timestamp(System.currentTimeMillis()));

        articleRepository.save(article);

        return true;
    }



    @Override
    public boolean deleteArticle(Integer id) {

        if (!articleRepository.existsById(id)) {
            return false;
        }

        articleRepository.deleteById(id);
        return true;
    }



    @Override
    public ArticleEntity getArticleById(int id) {
        return articleRepository.findById(id).orElse(null);
    }



    @Override
    public List<ArticleEntity> getArticlesByUserId(int userId) {
        return articleRepository.findByUserid(userId);
    }
}
