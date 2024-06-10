package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.tomjerry.sweethome.repository.FollowRepository;
import org.tomjerry.sweethome.service.FollowService;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void followUser(int followerId, int followingId) {
        FollowEntity follow = new FollowEntity(followerId, followingId);
        // 注意：这里假设 followRepository 有一个合适的方法来保存 FollowEntity
        // 如果不是，您可能需要自定义一个方法或调整现有方法
        followRepository.save(follow);
    }

    @Override
    public void unfollowUser(int user_id, int follow_user_id) {

    }

    @Override
    public List<FollowEntity> getFollow_user_id(int user_id) {
        return List.of();
    }

    @Override
    public List<FollowEntity> getUser_id(int follow_user_id) {
        return List.of();
    }

   /* @Override
    public void unfollowUser(int followerId, int followingId) {
        // 注意：这里需要确保 FollowRepository 有一个方法来处理取消关注
        // 可能是通过删除特定的 FollowEntity，或者更新其状态（如果适用）
        // 假设有一个 deleteByFollowerIdAndFollowingId 方法
        followRepository.deleteByFollowerIdAndFollowingId(followerId, followingId);
    }

    @Override
    public List<FollowEntity> getFollow_user_id(int user_id) {
        // 假设 FollowRepository 有一个方法来获取关注者的列表
        // 可能是 findByFollowerId 方法
        return followRepository.findByFollowerId(user_id);
    }*/

    /*@Override
    public List<FollowEntity> getUser_id(int follow_user_id) {
        // 假设 FollowRepository 有一个方法来获取被关注者的列表
        // 可能是 findByFollowingId 方法
        return followRepository.findByFollowingId(follow_user_id);
    }*/

    @Override
    public boolean isUserFollowing(int user_id, int follow_user_id) {
        // 调用 FollowRepository 中的合适方法来检查是否存在关注关系
        // 假设方法名为 existsByFollowerIdAndFollowingId
        return followRepository.existsByUserIdIdAndFollowUserId(user_id, follow_user_id);
    }
}
