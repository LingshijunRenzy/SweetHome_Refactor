package org.tomjerry.sweethome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    ArticleEntity findByTitle(String title);

    List<ArticleEntity> findByUserid(Integer userId);
    List<ArticleEntity> findByTitleContaining(String keyword);
    List<ArticleEntity> findByContentContaining(String keyword);
}
