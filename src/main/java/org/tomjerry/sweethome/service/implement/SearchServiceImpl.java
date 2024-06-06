package org.tomjerry.sweethome.service.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.ArticleRepository;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public SearchServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<ArticleEntity> searchArticle(String keyword, Pageable pageable) {
        return articleRepository.searchArticle(keyword, pageable);
    }

    @Override
    public Page<UserEntity> searchUser(String keyword, Pageable pageable) {
        return userRepository.searchUser(keyword, pageable);
    }
}
