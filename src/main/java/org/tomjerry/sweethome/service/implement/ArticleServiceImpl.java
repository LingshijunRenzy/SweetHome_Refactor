package org.tomjerry.sweethome.service.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.ArticleService;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }



    public ArticleEntity addArticle(String title, String content, int userId) {

        //check user
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        //check title
        if (title == null || title.isEmpty()) {
            throw new RuntimeException("Title cannot be empty");
        }
        if(title.length() > 50){
            throw new RuntimeException("Title is too long, max length is 50");
        }

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
            throw new RuntimeException("Article not found");
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(ArticleEntity.class, key);
            if (field == null) {
                throw new RuntimeException("Field not found");
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
            throw new RuntimeException("Article not found");
        }

        articleRepository.deleteById(id);
        return true;
    }



    @Override
    public ArticleEntity getArticleById(int id) {
        ArticleEntity article = articleRepository.findById(id).orElse(null);
        if(article == null){
            throw new RuntimeException("Article not found");
        }
        return article;
    }


    @Override
    public Page<ArticleEntity> getArticlesByUserId(int userId, int page, int size) {
        //check if user exist
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        return articleRepository.findByUserid(userId, PageRequest.of(page, size));
    }
}
