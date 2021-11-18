package com.codrut.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.codrut.data.NewsRepository;
import com.codrut.data.features.news.NewsRepositoryImpl;
import com.codrut.data.features.news.local.NewsLocalDataStore;
import com.codrut.data.features.news.local.mapper.ArticleToEntityMapper;
import com.codrut.data.features.news.remote.NewsRemoteSource;
import com.codrut.data.local.NewsDatabase;
import com.codrut.data.remote.HttpClientFactory;

import org.jetbrains.annotations.NotNull;

public class RepoModule {

    @NotNull
    private final Context context;
    @NotNull
    private final HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;

    public RepoModule(Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.newsDao(), new ArticleToEntityMapper());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            NewsDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }

}
