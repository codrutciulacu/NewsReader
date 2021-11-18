package com.codrut.data.features.news;

import androidx.annotation.NonNull;

import com.codrut.data.NewsRepository;
import com.codrut.data.features.news.local.NewsLocalDataStore;
import com.codrut.data.features.news.model.Article;
import com.codrut.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private final NewsLocalDataStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalDataStore localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::insertArticles)
                .onErrorResumeNext(localSource.getArticleList());
    }

}
