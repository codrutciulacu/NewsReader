package com.codrut.newsreader.feature.articledetails.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.codrut.data.NewsRepository;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

public class ArticleDetailsViewModel extends AndroidViewModel implements DefaultLifecycleObserver {

    public ArticleItemViewModel itemViewModel;

    public ArticleDetailsViewModel(@NotNull Application application, NewsRepository repository) {
        super(application);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
    }
}