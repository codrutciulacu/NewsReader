package com.codrut.newsreader.feature.articledetails.model.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codrut.data.NewsRepository;
import com.codrut.newsreader.NewsApplication;
import com.codrut.newsreader.feature.articledetails.model.ArticleDetailsViewModel;

public class ArticleDetailsViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private final Application application;

    public ArticleDetailsViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticleDetailsViewModel.class)) {
            NewsRepository repo = NewsApplication.getRepoProvider().provideNewsRepository();
            return (T) new ArticleDetailsViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class!");
    }
}
