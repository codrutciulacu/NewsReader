package com.codrut.data.features.news.remote.mapper;

import androidx.annotation.NonNull;

import com.codrut.data.features.news.model.Article;
import com.codrut.data.features.news.remote.model.ArticleDto;

import io.reactivex.functions.Function;

public class ArticleDtoToArticleMapper implements Function<ArticleDto, Article> {
    @Override
    public Article apply(@NonNull ArticleDto articleDto) {
        return new Article(null, articleDto.urlToImage, articleDto.title, articleDto.content, articleDto.description);
    }
}
