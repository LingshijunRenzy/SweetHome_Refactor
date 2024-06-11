package org.tomjerry.sweethome.pojo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "follows")
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId; // 关注者的用户ID
    @Column(name = "follow_user_id")
    private int followUserId; // 被关注者的用户ID

    @Column(name = "create_time")
    private Timestamp createTime;


    // 无参构造函数，JPA 最佳实践
    public FollowEntity() {
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public FollowEntity(int userId, int followUserId) {
        this.userId = userId;
        this.followUserId = followUserId;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(int followUserId) {
        this.followUserId = followUserId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}