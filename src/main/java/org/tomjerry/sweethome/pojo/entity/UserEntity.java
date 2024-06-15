package org.tomjerry.sweethome.pojo.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Timestamp create_time;
    private Timestamp update_time;
    private String avatar;
    private String signature;
    private Integer article_count;
    private Integer comment_count;
    private Integer liked_count;
    private Integer follow_count;
    private Integer fans_count;
    @Column(name = "is_admin")
    private Integer isAdmin;
    private Integer status;

    public UserEntity() {
        this.avatar = "default.jpg";
        this.signature = "这个人很懒，什么都没有留下";
        this.create_time = new Timestamp(System.currentTimeMillis());
        this.update_time = new Timestamp(System.currentTimeMillis());
        this.article_count = 0;
        this.comment_count = 0;
        this.liked_count = 0;
        this.follow_count = 0;
        this.fans_count = 0;
        this.isAdmin = 0;
        this.status = 1;
    }

    // Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getArticle_count() {
        return article_count;
    }

    public void setArticle_count(Integer article_count) {
        this.article_count = article_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getLiked_count() {
        return liked_count;
    }

    public void setLiked_count(Integer liked_count) {
        this.liked_count = liked_count;
    }

    public Integer getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(Integer follow_count) {
        this.follow_count = follow_count;
    }

    public Integer getFans_count() {
        return fans_count;
    }

    public void setFans_count(Integer fans_count) {
        this.fans_count = fans_count;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer is_admin) {
        this.isAdmin = is_admin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
