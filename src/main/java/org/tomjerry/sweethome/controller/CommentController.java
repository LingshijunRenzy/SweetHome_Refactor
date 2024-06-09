package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.vo.response.Result;

import java.util.List;

public interface CommentController {
    Result<CommentEntity> createComment(String content,Long articleId);
    Result<List<CommentEntity>> getCommentList(String articleId);
}
