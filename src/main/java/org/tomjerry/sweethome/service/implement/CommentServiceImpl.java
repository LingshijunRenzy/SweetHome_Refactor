package org.tomjerry.sweethome.service.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.repository.CommentRepository;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }



    @Override
    public CommentEntity addComment(String content, Integer article_id, Integer userId, Integer parentId) {
        //check if user and article exist
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        if (!articleRepository.existsById(article_id)) {
            throw new RuntimeException("Article not found");
        }

        //check if parent comment exist
        if (!commentRepository.existsById(parentId) && parentId != 0) {
            throw new RuntimeException("Parent comment not found");
        }

        CommentEntity comment;

        if(parentId != 0){
            comment = new CommentEntity(article_id, userId, content, parentId);
        }
        else{
            comment = new CommentEntity(article_id, userId, content);
        }

        commentRepository.save(comment);

        //update article comment count
        articleRepository.findById(article_id).ifPresent(article -> {
            article.setCommentCount(article.getCommentCount() + 1);
            articleRepository.save(article);
        });

        //update user comment count
        userRepository.findById(userId).ifPresent(user -> {
            user.setComment_count(user.getComment_count() + 1);
            userRepository.save(user);
        });

        return comment;
    }



    @Override
    public List<CommentEntity> getCommentsByArticleId(Integer article_id) {

        if(!articleRepository.existsById(article_id)){
            throw new RuntimeException("Article not found");
        }

        return commentRepository.findByArticleIdOrderByCreateTimeDesc(article_id);
    }



    @Override
    public Page<CommentEntity> getCommentsByArticleId(Integer articleId, Integer page, Integer size) {

        if(!articleRepository.existsById(articleId)){
            throw new RuntimeException("Article not found");
        }

        return commentRepository.findByArticleIdOrderByCreateTimeDesc(articleId, PageRequest.of(page, size));
    }



    @Override
    public Page<CommentEntity> getCommentsByUserId(Integer userId, Integer page, Integer size) {

        if(!userRepository.existsById(userId)){
            throw new RuntimeException("User not found");
        }

        return commentRepository.findByUserIdOrderByCreateTimeDesc(userId, PageRequest.of(page, size));
    }



    @Override
    public Page<CommentEntity> getCommentsByParentId(Integer parentId, Integer page, Integer size) {

        if(!commentRepository.existsById(parentId)){
            throw new RuntimeException("Parent comment not found");
        }

        return commentRepository.findByParentIdOrderByCreateTimeDesc(parentId, PageRequest.of(page, size));
    }



    @Override
    public boolean deleteComment(Integer commentId) {

        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }

        CommentEntity comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            //update article comment count
            ArticleEntity article = articleRepository.findById(comment.getArticleId()).orElse(null);
            if (article != null) {
                article.setCommentCount(article.getCommentCount() - 1);
                articleRepository.save(article);
            }

            //update user comment count
            userRepository.findById(comment.getUserId()).ifPresent(user -> {
                user.setComment_count(user.getComment_count() - 1);
                userRepository.save(user);
            });
        }

        commentRepository.deleteById(commentId);
        return true;
    }
}