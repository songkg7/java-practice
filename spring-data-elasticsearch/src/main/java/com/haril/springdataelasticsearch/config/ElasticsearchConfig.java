package com.haril.springdataelasticsearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.haril.springdataelasticsearch.article.repository")
public class ElasticsearchConfig extends ElasticsearchConfigurationSupport {

}
