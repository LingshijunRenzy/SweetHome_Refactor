package org.tomjerry.sweethome.dao;

import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;

import java.sql.SQLException;
import java.util.List;

public interface CommentDao{
    void createComment(int postId, String userName, String comment) throws SQLException;

    void addComment(int postId, String userName, String comment) throws SQLException;
    List<CommentEntity> getCommentsByPostId(int postId) throws SQLException;
}