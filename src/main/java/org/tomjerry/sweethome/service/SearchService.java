package org.tomjerry.sweethome.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.entity.UserEntity;

import java.util.List;

public interface SearchService {

    public Page<ArticleEntity> searchArticle(String keyword, Pageable pageable);

    public Page<UserEntity> searchUser(String keyword, Pageable pageable);
}
