package org.tomjerry.sweethome.repository;

import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<FollowEntity, Integer> {

    // 假设您有以下查询方法
    @Query("SELECT COUNT(f) > 0 FROM FollowEntity f WHERE f.user_id = ?1 AND f.follow_user_id = ?2")
    boolean existsByUserIdIdAndFollowUserId (int user_id, int follow_user_id );

    // 其他可能的查询方法...
}
