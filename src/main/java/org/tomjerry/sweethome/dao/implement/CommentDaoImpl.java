package org.tomjerry.sweethome.dao.implement;

import org.tomjerry.sweethome.dao.CommentDao;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private final DataSource dataSource;

    public CommentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createComment(int postId, String userName, String comment) throws SQLException {

    }

    @Override
    public void addComment(int postId, String userName, String comment) throws SQLException {
        String sql = "INSERT INTO comments (article_id, user_id, content) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, postId);
            stmt.setString(2, userName);
            stmt.setString(3, comment);
            stmt.executeUpdate();
        }
    }
/*
    @Override
    public void addComment(int postId, String userName, String comment) throws SQLException {

    }*/

    @Override
    public List<CommentEntity> getCommentsByPostId(int postId) throws SQLException {
//        List<CommentEntity> comments = new ArrayList<>();
//        String sql = "SELECT * FROM comments WHERE comments.article_id = ? ORDER BY create_time DESC";
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, postId);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    CommentEntity comment = new CommentEntity(
//                            rs.getInt("id"),
//                            rs.getInt("article_id"),
//                            rs.getString("user_id"),
//                            rs.getString("content"),
//                            rs.getTimestamp("create_time")
//                    );
//                    comments.add(comment);
//                }
//            }
//        }
//        return comments;
        return null;
    }
}