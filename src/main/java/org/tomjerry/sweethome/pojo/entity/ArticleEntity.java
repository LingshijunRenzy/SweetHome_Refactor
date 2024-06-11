package org.tomjerry.sweethome.pojo.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @Column(name = "user_id")
    private Integer userid;

    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "like_count")
    private Integer likeCount;
    @Column(name = "comment_count")
    private Integer commentCount;
    private Integer status;

    public ArticleEntity() {
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.updateTime = new Timestamp(System.currentTimeMillis());
        this.viewCount = 0;
        this.likeCount = 0;
        this.commentCount = 0;
        this.status = 1;
    }

    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer user_id) {
        this.userid = user_id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp create_time) {
        this.createTime = create_time;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp update_time) {
        this.updateTime = update_time;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer view_count) {
        this.viewCount = view_count;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer like_count) {
        this.likeCount = like_count;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer comment_count) {
        this.commentCount = comment_count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
