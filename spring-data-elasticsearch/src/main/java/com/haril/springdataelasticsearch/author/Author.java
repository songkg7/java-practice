package com.haril.springdataelasticsearch.author;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Document(indexName = "authors")
public class Author {

    @Id
    private String id;

    private String name;

    public Author(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

}
