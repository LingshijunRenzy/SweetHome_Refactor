package org.tomjerry.sweethome.pojo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "follows")
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id; // 关注者的用户ID
    private int follow_user_id; // 被关注者的用户ID
    @Column(name = "create_time")
    private Timestamp createTime;
    // 无参构造函数，JPA 最佳实践
    public FollowEntity() {
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    // 构造函数、Getter 和 Setter 方法
    public FollowEntity(int user_id, int follow_user_id) {
        this.user_id = user_id;
        this.follow_user_id = follow_user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 更新方法名以匹配字段名
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // 更新方法名以匹配字段名
    public int getFollow_user_id() {
        return follow_user_id;
    }

    public void setFollow_user_id(int follow_user_id) {
        this.follow_user_id = follow_user_id;
    }
}