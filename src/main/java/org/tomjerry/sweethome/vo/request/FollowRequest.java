package org.tomjerry.sweethome.vo.request;

public class FollowRequest {
    private String action;
    private Integer followingId;

    public FollowRequest(String action, Integer followingId) {
        this.action = action;
        this.followingId = followingId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Integer followingId) {
        this.followingId = followingId;
    }
}
