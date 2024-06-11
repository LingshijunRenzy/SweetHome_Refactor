package org.tomjerry.sweethome.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tomjerry.sweethome.pojo.entity.LikeEntity;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Integer> {


    // 假设您有以下查询方法
    @Query("SELECT COUNT(f) > 0 FROM FollowEntity f WHERE f.userId = ?1 AND f.followUserId = ?2")
    boolean existsByUserIdIdAndFollowUserId (int user_id, int follow_user_id );


    FollowEntity findByUserIdAndFollowUserId(int userId, int followUserId);


    Page<FollowEntity> findByUserId(int userId, Pageable pageable);


    Page<FollowEntity> findByFollowUserId(int followUserId, Pageable pageable);


    @Transactional
    void deleteByUserIdAndFollowUserId(int userId, int followUserId);
}
