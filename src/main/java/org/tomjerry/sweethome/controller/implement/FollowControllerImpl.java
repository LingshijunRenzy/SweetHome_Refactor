package org.tomjerry.sweethome.controller.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.tomjerry.sweethome.service.FollowService;
import org.tomjerry.sweethome.vo.response.Result;

import java.security.Principal;

@RestController
@RequestMapping("/follow")
public class FollowControllerImpl {

    private final FollowService followService;

    @Autowired
    public FollowControllerImpl(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow")
    public Result <FollowEntity>followUser(@RequestParam Integer followingId, Principal principal) {
        if (principal == null) {
            return new Result<>(401, "User not authenticated", null);
        }

        int followerId = Integer.parseInt(principal.getName());

        followService.followUser(followerId, followingId);
        return new Result<>(200, "Followed user successfully", null);
    }

    @PostMapping("/unfollow")
    public Result<FollowEntity> unfollowUser(@RequestParam Integer followingId, Principal principal) {
        if (principal == null) {
            return new Result<>(401, "User not authenticated", null);
        }

        int followerId = Integer.parseInt(principal.getName());

        followService.unfollowUser(followerId, followingId);
        return new Result<>(200, "Unfollowed user successfully", null);
    }
}