package org.tomjerry.sweethome.service;

import org.springframework.data.domain.Page;
import org.tomjerry.sweethome.pojo.entity.LikeEntity;

public interface LikeService {


    boolean likeContent(Integer userId, Integer contentType, Integer contentId);


    boolean unlikeContent(Integer userId, Integer contentType, Integer contentId);


    boolean isUserLikedContent(Integer userId, Integer contentType, Integer contentId);


    Page<LikeEntity> getUserLikes(Integer userId, Integer page, Integer size);


    Page<LikeEntity> getContentLikes(Integer contentType, Integer contentId, Integer page, Integer size);
}
