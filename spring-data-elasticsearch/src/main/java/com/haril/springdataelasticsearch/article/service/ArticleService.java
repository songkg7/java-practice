package com.haril.springdataelasticsearch.article.service;

import com.haril.springdataelasticsearch.article.Article;
import com.haril.springdataelasticsearch.article.repository.ArticleRepository;
import com.haril.springdataelasticsearch.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void createArticle(Author author, String contents) {
        Article article = Article.of(UUID.randomUUID().toString(), contents, List.of(author));
        articleRepository.save(article);
    }

}
