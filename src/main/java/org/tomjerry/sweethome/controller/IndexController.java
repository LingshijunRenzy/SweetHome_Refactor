package org.tomjerry.sweethome.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.vo.response.Result;

@RestController
public interface IndexController {
    Result<Page<ArticleEntity>> getAllArticles(String sort, Integer page, Integer size);
}
