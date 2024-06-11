package org.tomjerry.sweethome.service.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.tomjerry.sweethome.repository.FollowRepository;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.FollowService;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowServiceImpl(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void followUser(int followerId, int followingId) {
        //check followerId and followingId
        if(!userRepository.existsById(followerId) || !userRepository.existsById(followingId)){
            throw new IllegalArgumentException("User does not exist");
        }
        //check if the user is already following
        if(followRepository.existsByUserIdIdAndFollowUserId(followerId, followingId)){
            throw new IllegalArgumentException("User is already following");
        }


        FollowEntity follow = new FollowEntity(followerId, followingId);
        followRepository.save(follow);
    }

    @Override
    public void unfollowUser(int user_id, int follow_user_id) {
        //check if the user is already following
        if(!followRepository.existsByUserIdIdAndFollowUserId(user_id, follow_user_id)){
            throw new IllegalArgumentException("User is not following");
        }

        followRepository.deleteByUserIdAndFollowUserId(user_id, follow_user_id);
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



    @Override
    public Page<FollowEntity> getFollowUser(int user_id, int page, int size) {
        //check if the user exists
        if(!userRepository.existsById(user_id)){
            throw new IllegalArgumentException("User does not exist");
        }

        return followRepository.findByUserId(user_id, PageRequest.of(page, size));
    }



    @Override
    public Page<FollowEntity> getFollowedUser(int follow_user_id, int page, int size) {
        //check if the user exists
        if(!userRepository.existsById(follow_user_id)){
            throw new IllegalArgumentException("User does not exist");
        }

        return followRepository.findByFollowUserId(follow_user_id, PageRequest.of(page, size));
    }
}
