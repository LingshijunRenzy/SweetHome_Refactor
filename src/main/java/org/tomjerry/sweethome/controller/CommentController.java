package org.tomjerry.sweethome.controller;

import org.springframework.data.domain.Page;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.vo.request.AddCommentRequest;
import org.tomjerry.sweethome.vo.response.Result;


public interface CommentController {


    Result<Page<CommentEntity>> getCommentsByArticleId(Integer articleId, Integer page, Integer size);


    Result<Page<CommentEntity>> getCommentsByUserId(Integer userId, Integer page, Integer size);


    Result<Page<CommentEntity>> getCommentsByParentId(Integer parentId, Integer page, Integer size);


    Result<CommentEntity> createComment(AddCommentRequest addCommentRequest);


    Result<String> deleteComment(Integer commentId);

}
