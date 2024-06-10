package org.tomjerry.sweethome.dao.implement;

import org.tomjerry.sweethome.dao.FollowDao;
import org.tomjerry.sweethome.pojo.entity.FollowEntity;
import org.tomjerry.sweethome.util.security.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FollowDaoImpl implements FollowDao {

    @Override
    public void followUser(FollowEntity follow) {
        String sql = "INSERT INTO follows (user_id, follow_user_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, follow.getUser_id());
            pstmt.setInt(2, follow.getFollow_user_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unfollowUser(int followerId, int followingId) {
        String sql = "DELETE FROM follows WHERE user_id = ? AND follow_user_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, followerId);
            pstmt.setInt(2, followingId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FollowEntity> getFollow_user_id(int user_id) {
        String sql = "SELECT * FROM follows WHERE user_id = ?";
        List<FollowEntity> following = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FollowEntity follow = new FollowEntity(rs.getInt("user_id"), rs.getInt("follow_user_id"));
                follow.setId(rs.getInt("id"));
                following.add(follow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return following;
    }

    @Override
    public List<FollowEntity> getUser_id(int following_user_id) {
        String sql = "SELECT * FROM follows WHERE follow_user_id = ?";
        List<FollowEntity> followers = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, following_user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                FollowEntity follow = new FollowEntity(rs.getInt("user_id"), rs.getInt("follow_user_id"));
                follow.setId(rs.getInt("id"));
                followers.add(follow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return followers;
    }
}
