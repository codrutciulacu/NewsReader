package com.codrut.newsreader.feature.articledetails.model.mapper;

import com.codrut.data.features.news.model.Article;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

import io.reactivex.functions.Function;

public class ArticleToArticleVMMapper implements Function<Article, ArticleItemViewModel> {
    @Override
    public ArticleItemViewModel apply(Article article) {
        return new ArticleItemViewModel(article.id, article.imageUrl, article.title, article.description, article.content);
    }
}
