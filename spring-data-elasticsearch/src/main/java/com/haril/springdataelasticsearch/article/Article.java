package com.haril.springdataelasticsearch.article;

import com.haril.springdataelasticsearch.author.Author;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "articles")
public class Article {

    @Id
    private String id;

    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

    private Article() {
    }

    private Article(String id, String title, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public static Article of(String id, String title, List<Author> authors) {
        return new Article(id, title, authors);
    }

}
