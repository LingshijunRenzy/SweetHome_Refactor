package org.tomjerry.sweethome.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.LikeEntity;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Integer>{


    boolean existsByUserIdAndContentTypeAndContentId(Integer userId, Integer contentType, Integer contentId);


    LikeEntity findByUserIdAndContentTypeAndContentId(Integer userId, Integer contentType, Integer contentId);


    Page<LikeEntity> findByUserId(Integer userId, Pageable pageable);


    Page<LikeEntity> findByContentTypeAndContentId(Integer contentType, Integer contentId, Pageable pageable);
}
