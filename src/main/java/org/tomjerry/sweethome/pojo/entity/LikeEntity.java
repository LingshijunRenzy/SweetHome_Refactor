package org.tomjerry.sweethome.pojo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "likes")
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "content_type")
    private Integer contentType;

    @Column(name = "content_id")
    private Integer contentId;

    private Timestamp createTime;

    public LikeEntity() {
    }

    public LikeEntity(Integer userId, Integer contentType, Integer contentId) {
        this.userId = userId;
        this.contentType = contentType;
        this.contentId = contentId;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
