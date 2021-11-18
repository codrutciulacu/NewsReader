package com.codrut.newsreader.feature.newslist.model.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codrut.data.NewsRepository;
import com.codrut.newsreader.NewsApplication;
import com.codrut.newsreader.feature.newslist.model.NewsListViewModel;

public class NewsListViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public NewsListViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repo = NewsApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsListViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class!");
    }
}
