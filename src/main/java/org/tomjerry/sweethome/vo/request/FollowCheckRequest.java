package org.tomjerry.sweethome.vo.request;

public class FollowCheckRequest {
    private Integer userId;
    private Integer followUserId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }
}
