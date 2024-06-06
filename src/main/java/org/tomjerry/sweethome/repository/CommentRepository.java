package org.tomjerry.sweethome.repository;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("SELECT c FROM CommentEntity c WHERE c.articleId = ?1 ORDER BY c.create_time DESC")
    List<CommentEntity> findByArticleIdOrderByCreateTimeDesc(Long article_id);
}