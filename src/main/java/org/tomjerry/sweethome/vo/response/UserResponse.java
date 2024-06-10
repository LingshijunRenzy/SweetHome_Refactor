package org.tomjerry.sweethome.vo.response;

import org.tomjerry.sweethome.pojo.entity.UserEntity;

import java.sql.Timestamp;

public class UserResponse {
    private Integer id;
    private String username;

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
    private Integer is_admin;
    private Integer status;

    public UserResponse(UserEntity userEntity){
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.phone = userEntity.getPhone();
        this.create_time = userEntity.getCreate_time();
        this.update_time = userEntity.getUpdate_time();
        this.avatar = userEntity.getAvatar();
        this.signature = userEntity.getSignature();
        this.article_count = userEntity.getArticle_count();
        this.comment_count = userEntity.getComment_count();
        this.liked_count = userEntity.getLiked_count();
        this.follow_count = userEntity.getFollow_count();
        this.fans_count = userEntity.getFans_count();
        this.is_admin = userEntity.getIs_admin();
        this.status = userEntity.getStatus();
    }


    //Getter and Setter

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

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
