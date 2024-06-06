package org.tomjerry.sweethome.controller.implement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.response.Result;
import org.tomjerry.sweethome.service.CommentService;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.controller.CommentController;


import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    // 创建评论
    @PostMapping
    public Result<CommentEntity> createComment(
            @RequestParam("content") String content,
            @RequestParam("article_id") Long articleId // 假设评论关联到某个帖子
            // 可能还需要其他参数，如userId等
            // ...
    ) {
        Result<CommentEntity> result = new Result<>();
        CommentEntity comment = commentService.createComment(content, articleId); // 调用服务层方法

        if (comment != null) {
            result.setCode(200);
            result.setMessage("Comment add successfully");
            result.setData(comment);
        } else {
            result.setCode(400);
            result.setMessage("Failed to create comment");
        }

        return result;
    }

    // 获取评论列表（例如，基于帖子ID）
    @GetMapping("/{article_id}")
    public Result<List<CommentEntity>> getCommentsByArticleId(
            @PathVariable("article_id") Long article_id
            // 可能还需要其他参数，如分页信息等
            // ...
    ) {
        Result<List<CommentEntity>> result = new Result<>();
        List<CommentEntity> commentList = commentService.getCommentsByArticleId(article_id); // 调用服务层方法

        if (commentList != null && !commentList.isEmpty()) {
            result.setCode(200);
            result.setMessage("Comments retrieved successfully");
            result.setData(commentList);
        } else {
            result.setCode(404);
            result.setMessage("No comments found for the given post");
        }

        return result;
    }


    @Override
    public Result<List<CommentEntity>> getCommentList(String articleId) {
        return null;
    }
}
// 可能还有其他方法，如更新评论、删除评论等
// ...
