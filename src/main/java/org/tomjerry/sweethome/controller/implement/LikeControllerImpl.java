package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.controller.LikeController;
import org.tomjerry.sweethome.service.LikeService;
import org.tomjerry.sweethome.vo.request.LikeRequest;
import org.tomjerry.sweethome.vo.response.Result;


@RestController
@RequestMapping("/like")
public class LikeControllerImpl implements LikeController {

    private final LikeService likeService;

    public LikeControllerImpl(LikeService likeService) {
        this.likeService = likeService;
    }

    @Override
    @PostMapping
    public Result<String> HandleLikeRequest(@RequestAttribute Integer userId,
                                            @RequestBody LikeRequest likeRequest) {

        String action = likeRequest.getAction();

        if (action.equals("like")) {
            likeService.likeContent(userId, likeRequest.getContentType(), likeRequest.getContentId());
            return new Result<>(200, "Liked successfully", null);

        } else if (action.equals("unlike")) {
            likeService.unlikeContent(userId, likeRequest.getContentType(), likeRequest.getContentId());
            return new Result<>(200, "Unliked successfully", null);

        } else {
            throw new RuntimeException("Invalid action");
        }
    }
}
