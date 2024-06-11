package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.request.FollowRequest;
import org.tomjerry.sweethome.vo.response.Result;

public interface FollowController {

    Result<String> handleFollowRequest(Integer userId, FollowRequest followRequest);

    // 如果还有其他方法，也可以在这里定义
}