package com.codrut.data.features.news.local.mapper;

import com.codrut.data.features.news.local.ArticleEntity;
import com.codrut.data.features.news.model.Article;

public class ArticleToEntityMapper {

    public Article entityToArticle(ArticleEntity entity) {
        return new Article(entity.id, entity.imageUrl, entity.title, entity.content, entity.description);
    }

    public ArticleEntity articleToEntity(Article article) {
        ArticleEntity entity = new ArticleEntity();

        entity.imageUrl = article.imageUrl;
        entity.title = article.title;
        entity.content = article.content;
        entity.description = article.description;

        return entity;
    }
}
