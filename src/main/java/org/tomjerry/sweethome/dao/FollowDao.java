package org.tomjerry.sweethome.dao;

import org.tomjerry.sweethome.pojo.entity.FollowEntity;

import java.util.List;

public interface FollowDao {
    void followUser(FollowEntity follow);
    void unfollowUser(int followerId, int followingId);
    List<FollowEntity> getFollow_user_id(int user_id);
    List<FollowEntity> getUser_id(int following_user_id);
}
