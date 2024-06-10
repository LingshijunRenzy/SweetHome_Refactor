package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.response.Result;

import java.security.Principal;

public interface FollowController {

    Result handleFollowRequest(String action, int followingId, Principal principal);

    // 如果还有其他方法，也可以在这里定义
}