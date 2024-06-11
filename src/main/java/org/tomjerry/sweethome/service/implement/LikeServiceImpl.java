package org.tomjerry.sweethome.service.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.LikeEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.repository.CommentRepository;
import org.tomjerry.sweethome.repository.LikeRepository;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.LikeService;


@Service
public class LikeServiceImpl implements LikeService {

    LikeRepository likeRepository;
    ArticleRepository articleRepository;
    CommentRepository commentRepository;
    UserRepository userRepository;

    public LikeServiceImpl(LikeRepository likeRepository, ArticleRepository articleRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }



    @Override
    public boolean likeContent(Integer userId, Integer contentType, Integer contentId) {
        //check if user has already liked the content
        if(likeRepository.existsByUserIdAndContentTypeAndContentId(userId, contentType, contentId)) {
            throw new RuntimeException("User has already liked the content");
        }

        //check if content exists
        if(contentType == 1) {
            if(!articleRepository.existsById(contentId)) {
                throw new RuntimeException("Article does not exist");
            }
        } else if(contentType == 2) {
            if(!commentRepository.existsById(contentId)) {
                throw new RuntimeException("Comment does not exist");
            }
        } else {
            throw new RuntimeException("Invalid content type");
        }

        LikeEntity likeEntity = new LikeEntity(userId, contentType, contentId);
        likeRepository.save(likeEntity);

        return true;
    }



    @Override
    public boolean unlikeContent(Integer userId, Integer contentType, Integer contentId) {
        //check if like exists
        if(!likeRepository.existsByUserIdAndContentTypeAndContentId(userId, contentType, contentId)) {
            throw new RuntimeException("Like does not exist");
        }

        Integer id = likeRepository.findByUserIdAndContentTypeAndContentId(userId, contentType, contentId).getId();

        likeRepository.deleteById(id);

        return true;
    }



    @Override
    public boolean isUserLikedContent(Integer userId, Integer contentType, Integer contentId) {
        return likeRepository.existsByUserIdAndContentTypeAndContentId(userId, contentType, contentId);
    }



    @Override
    public Page<LikeEntity> getUserLikes(Integer userId, Integer page, Integer size) {
        //check if user exists;
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User does not exist");
        }

        return likeRepository.findByUserId(userId, PageRequest.of(page, size));
    }



    @Override
    public Page<LikeEntity> getContentLikes(Integer contentType, Integer contentId, Integer page, Integer size) {
        //check if content exists
        if(contentType == 1) {
            if(!articleRepository.existsById(contentId)) {
                throw new RuntimeException("Article does not exist");
            }
        } else if(contentType == 2) {
            if(!commentRepository.existsById(contentId)) {
                throw new RuntimeException("Comment does not exist");
            }
        } else {
            throw new RuntimeException("Invalid content type");
        }

        return likeRepository.findByContentTypeAndContentId(contentType, contentId, PageRequest.of(page, size));
    }

}
