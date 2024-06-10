package org.tomjerry.sweethome.service;

import org.springframework.data.domain.Page;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;


import java.util.List;

public interface CommentService {


    CommentEntity addComment(String content, Integer article_id, Integer userId, Integer parentId);


    List<CommentEntity> getCommentsByArticleId(Integer article_id) ;


    Page<CommentEntity> getCommentsByArticleId(Integer articleId, Integer page, Integer size) ;


    Page<CommentEntity> getCommentsByUserId(Integer userId, Integer page, Integer size) ;


    Page<CommentEntity> getCommentsByParentId(Integer parentId, Integer page, Integer size) ;


    boolean deleteComment(Integer commentId);
}
