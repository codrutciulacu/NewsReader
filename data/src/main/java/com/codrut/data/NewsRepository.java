package com.codrut.data;

import com.codrut.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {
    Single<List<Article>> getNewsArticles();
}
