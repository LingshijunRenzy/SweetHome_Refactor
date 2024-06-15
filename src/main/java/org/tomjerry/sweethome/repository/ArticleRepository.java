package org.tomjerry.sweethome.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    ArticleEntity findByTitle(String title);

    List<ArticleEntity> findByUserid(Integer userId);
    Page<ArticleEntity> findByUserid(Integer userId, Pageable pageable);


    List<ArticleEntity> findByTitleContaining(String keyword);


    List<ArticleEntity> findByContentContaining(String keyword);


    @Query("SELECT a FROM ArticleEntity a WHERE " +
            "a.title LIKE %:keyword% OR a.content LIKE %:keyword% " +
            "ORDER BY CASE WHEN a.title LIKE %:keyword% THEN 1 ELSE 2 END")
    Page<ArticleEntity> searchArticle(@Param("keyword") String keyword, Pageable pageable);


    Page<ArticleEntity> findAllByOrderByUpdateTimeDesc(Pageable pageable);


    Page<ArticleEntity> findAllByOrderByLikeCountDesc(Pageable pageable);


    int countByUserid(Integer userId);
}
