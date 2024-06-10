package org.tomjerry.sweethome.service;

import org.tomjerry.sweethome.pojo.entity.FollowEntity;

import java.util.List;

public interface FollowService {
    void followUser(int user_id, int follow_user_id);

    void unfollowUser(int user_id, int follow_user_id);

    List<FollowEntity> getFollow_user_id(int user_id);

    List<FollowEntity> getUser_id(int follow_user_id);

    boolean isUserFollowing(int user_id, int follow_user_id);
}
