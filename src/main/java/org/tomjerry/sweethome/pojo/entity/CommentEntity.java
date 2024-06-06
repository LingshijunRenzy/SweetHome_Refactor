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
    private String user_id;

    private Timestamp create_time;

    // Optional fields depending on your requirements
    private Integer like_count; // If you want to track likes on comments
    private Integer reply_count; // If you want to track replies to comments
    private Integer status; // If you want to manage the status of comments (e.g., approved, pending, rejected)


    // 无参数的构造函数，供ORM框架使用
    public CommentEntity() {
        // 设置默认值，如果需要的话
        this.create_time = new Timestamp(System.currentTimeMillis());
        // 可以初始化其他可选字段
    }

    public CommentEntity(int id, int article_id, String user_id, String content, Timestamp create_time) {
        this.create_time = new Timestamp(System.currentTimeMillis());
        // Initialize other optional fields if needed
        // this.like_count = 0;
        // this.reply_count = 0;
        // this.status = 1; // Assuming 1 represents an approved status
        this.id=id;
        this.articleId=article_id;
        this.user_id=user_id;
        this.content=content;
        /*this.like_count=like_count;
        this.reply_count=reply_count;
*/
    }

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for articleId
    public Integer getArticle_id() {
        return articleId;
    }

    public void setArticleId(Integer article_id) {
        this.articleId = article_id;
    }

    // Getter and Setter for userId
    public String getUsername() {
        return user_id;
    }

    public void setUsername(String user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for create_time
    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    // Add getter and setter for optional fields if needed
    // ...
}