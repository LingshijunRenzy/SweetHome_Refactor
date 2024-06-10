package org.tomjerry.sweethome.controller.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.SearchController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.service.SearchService;
import org.tomjerry.sweethome.vo.response.SearchResponse;


@RestController
@RequestMapping("/search")
public class SearchControllerImpl implements SearchController {

    private final SearchService searchService;


    public SearchControllerImpl(SearchService searchService) {
        this.searchService = searchService;
    }


    @Override
    @GetMapping
    public SearchResponse<?> search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "article") String type,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size);

        if("article".equals(type)){
            Page<ArticleEntity> articlePage = searchService.searchArticle(keyword, pageable);
            return new SearchResponse<>(200, "success", articlePage);
        }
        else if ("user".equals(type)){
            Page<UserEntity> userPage = searchService.searchUser(keyword, pageable);
            return new SearchResponse<>(200, "success", userPage);
        }
        else{
            throw new RuntimeException("Invalid search type");
        }

    }
}
