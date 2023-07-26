package com.haril.springdataelasticsearch.article.controller;

import com.haril.springdataelasticsearch.article.service.ArticleService;
import com.haril.springdataelasticsearch.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public void save() {
        articleService.createArticle(new Author("haril"), "spring data elasticsearch");
    }

}
