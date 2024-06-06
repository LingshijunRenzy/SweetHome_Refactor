package org.tomjerry.sweethome.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.CommentEntity;
import org.tomjerry.sweethome.repository.CommentRepository;
import org.tomjerry.sweethome.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentEntity createComment(String content, Long article_id) {
        return null;
    }

    @Override
    public List<CommentEntity> getCommentsByArticleId(Long article_id) {
        return commentRepository.findByArticleIdOrderByCreateTimeDesc(article_id);
    }
}