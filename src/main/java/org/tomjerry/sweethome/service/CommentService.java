package org.tomjerry.sweethome.service;

import org.tomjerry.sweethome.pojo.entity.CommentEntity;


import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    CommentEntity createComment(String content, Long article_id );
    List<CommentEntity> getCommentsByArticleId(Long article_id) ;
}
