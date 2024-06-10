package org.tomjerry.sweethome.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query("SELECT c FROM CommentEntity c WHERE c.articleId = ?1 ORDER BY c.createTime DESC")
    List<CommentEntity> findByArticleIdOrderByCreateTimeDesc(Integer article_id);


    Page<CommentEntity> findByUserIdOrderByCreateTimeDesc(Integer userId, Pageable pageable);


    Page<CommentEntity> findByArticleIdOrderByCreateTimeDesc(Integer articleId, Pageable pageable);


    Page<CommentEntity> findByParentIdOrderByCreateTimeDesc(Integer parentId, Pageable pageable);
}