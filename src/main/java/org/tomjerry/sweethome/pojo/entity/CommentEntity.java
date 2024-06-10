package org.tomjerry.sweethome.pojo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @Column(name = "article_id")
    private Integer articleId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "create_time")
    private Timestamp createTime;
    private Integer like_count;
    @Column(name = "parent_id")
    private Integer parentId;
    private Integer status;


    // 无参数的构造函数，供ORM框架使用
    public CommentEntity() {
        // 设置默认值，如果需要的话
        this.createTime = new Timestamp(System.currentTimeMillis());
        // 可以初始化其他可选字段
    }

    public CommentEntity(int id, int articleId, int userId, String content, Timestamp createTime) {
        this.createTime = new Timestamp(System.currentTimeMillis());
        // Initialize other optional fields if needed
        // this.like_count = 0;
        // this.reply_count = 0;
        // this.status = 1; // Assuming 1 represents an approved status
        this.id=id;
        this.articleId=articleId;
        this.userId = userId;
        this.content=content;
        /*this.like_count=like_count;
        this.reply_count=reply_count;
*/
    }

    public CommentEntity(int articleId, int userId, String content) {
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.articleId=articleId;
        this.userId = userId;
        this.content=content;
        this.like_count=0;
        this.parentId=null;
        this.status=1;
    }

    public CommentEntity(int articleId, int userId, String content, Integer parent_id) {
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.articleId=articleId;
        this.userId = userId;
        this.content=content;
        this.like_count=0;
        this.parentId=parent_id;
        this.status=1;
    }

    //Getter and Setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parent_id) {
        this.parentId = parent_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}