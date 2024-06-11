package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.request.LikeRequest;
import org.tomjerry.sweethome.vo.response.Result;

public interface LikeController {

    Result<String> HandleLikeRequest(Integer userId, LikeRequest likeRequest);

}
