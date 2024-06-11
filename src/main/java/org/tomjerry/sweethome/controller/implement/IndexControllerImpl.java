package org.tomjerry.sweethome.controller.implement;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomjerry.sweethome.controller.IndexController;
import org.tomjerry.sweethome.pojo.entity.ArticleEntity;
import org.tomjerry.sweethome.service.ArticleService;
import org.tomjerry.sweethome.vo.response.Result;


@RestController
@RequestMapping("/index")
public class IndexControllerImpl implements IndexController {

    private final ArticleService articleService;

    public IndexControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @GetMapping
    public Result<Page<ArticleEntity>> getAllArticles(
            @RequestParam(defaultValue = "time") String sort,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        if(sort.equals("time")){
            return new Result<>(200, "Get articles success", articleService.getAllArticlesByTime(page, size));
        }else if(sort.equals("like")){
            return new Result<>(200, "Get articles success", articleService.getAllArticlesByLikeCount(page, size));
        } else{
            throw new IllegalArgumentException("Invalid sort type");
        }
    }
}
