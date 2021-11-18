package com.codrut.data.features.news.remote;

import androidx.annotation.NonNull;

import com.codrut.data.features.news.model.Article;
import com.codrut.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.codrut.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "d4dd58bf54da468d86a10ecd835ce9d2";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(@NonNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new NewsDtoToNewsMapper());
    }
}
