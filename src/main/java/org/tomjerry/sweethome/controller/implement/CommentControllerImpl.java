package org.tomjerry.sweethome.controller.implement;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.tomjerry.sweethome.vo.request.AddCommentRequest;
import org.tomjerry.sweethome.vo.response.Result;
import org.tomjerry.sweethome.service.CommentService;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.controller.CommentController;



@RestController
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }



    @Override
    @GetMapping("article/{articleId}/comments")
    public Result<Page<CommentEntity>> getCommentsByArticleId(
            @PathVariable Integer articleId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<CommentEntity> comments = commentService.getCommentsByArticleId(articleId, page, size);

        if (comments != null) {
            return new Result<>(200, "Get comments success", comments);
        } else {
            throw new RuntimeException("Comments not found");
        }
    }



    @Override
    @GetMapping("user/{userId}/comments")
    public Result<Page<CommentEntity>> getCommentsByUserId(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<CommentEntity> comments = commentService.getCommentsByUserId(userId, page, size);

        if(comments != null){
            return new Result<>(200, "Get comments success", comments);
        } else {
            throw new RuntimeException("Comments not found");
        }
    }



    @Override
    @GetMapping("comment/{parentId}/comments")
    public Result<Page<CommentEntity>> getCommentsByParentId(
            @PathVariable Integer parentId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<CommentEntity> comments = commentService.getCommentsByParentId(parentId, page, size);

        if(comments != null){
            return new Result<>(200, "Get comments success", comments);
        } else {
            throw new RuntimeException("Comments not found");
        }
    }



    @Override
    @PostMapping("comment/add")
    public Result<CommentEntity> createComment(@RequestBody AddCommentRequest addCommentRequest) {
        CommentEntity comment = commentService.addComment(
                addCommentRequest.getContent(),
                addCommentRequest.getArticleId(),
                addCommentRequest.getUserId(),
                addCommentRequest.getParentId());

        return new Result<>(200, "Comment added successfully", comment);
    }



    @Override
    @DeleteMapping("comment/{comment_id}")
    public Result<String> deleteComment(@PathVariable("comment_id") Integer commentId) {

        boolean success = commentService.deleteComment(commentId);

        if (success) {
            return new Result<>(200, "Comment deleted successfully", null);
        } else {
            return new Result<>(400, "Failed to delete comment", null);
        }

    }
}
