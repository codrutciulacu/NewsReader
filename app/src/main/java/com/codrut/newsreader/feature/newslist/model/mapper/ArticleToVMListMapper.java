package com.codrut.newsreader.feature.newslist.model.mapper;

import androidx.annotation.NonNull;

import com.codrut.data.features.news.model.Article;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.functions.Function;

public class ArticleToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(@NonNull List<Article> articles) {
        return articles.stream()
                .map(article -> new ArticleItemViewModel(article.id, article.imageUrl, article.title, article.description, article.content))
                .collect(Collectors.toList());
    }
}
