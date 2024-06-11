package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.FollowController;
import org.tomjerry.sweethome.service.FollowService;
import org.tomjerry.sweethome.vo.request.FollowRequest;
import org.tomjerry.sweethome.vo.response.Result;


@RestController
@RequestMapping("/follow")
public class FollowControllerImpl implements FollowController {

    private final FollowService followService;

    public FollowControllerImpl(FollowService followService) {
        this.followService = followService;
    }

    @Override
    @PostMapping
    public Result<String> handleFollowRequest(
            @RequestAttribute Integer userId,
            @RequestBody FollowRequest followRequest) {

        String action = followRequest.getAction();
        Integer followUserId = followRequest.getFollowingId();

        if("follow".equals(action)){
            followService.followUser(userId, followUserId);
            return new Result<>(200, "Follow success", null);
        }else if("unfollow".equals(action)){
            followService.unfollowUser(userId, followUserId);
            return new Result<>(200, "Unfollow success", null);
        }else {
            throw new IllegalArgumentException("Invalid action");
        }

    }
}
