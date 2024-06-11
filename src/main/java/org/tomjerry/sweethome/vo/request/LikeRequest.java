package org.tomjerry.sweethome.vo.request;

public class LikeRequest {
    private String action;
    private int contentType;
    private int contentId;

    public LikeRequest(String action, int contentType, int contentId) {
        this.action = action;
        this.contentType = contentType;
        this.contentId = contentId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}
