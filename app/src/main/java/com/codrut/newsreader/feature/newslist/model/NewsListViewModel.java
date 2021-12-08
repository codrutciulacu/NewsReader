package com.codrut.newsreader.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.codrut.data.NewsRepository;
import com.codrut.newsreader.feature.newslist.listener.NewsHandler;
import com.codrut.newsreader.feature.newslist.model.mapper.ArticleToVMListMapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class NewsListViewModel extends AndroidViewModel implements NewsHandler, DefaultLifecycleObserver {

    public final ObservableBoolean isLoading;
    public final ObservableField<String> errorMessage;
    private final NewsRepository repository;
    public ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();
    public final PublishSubject<ArticleItemViewModel> events;
    private Disposable disposable;

    public NewsListViewModel(@NonNull Application application, NewsRepository repository) {
        super(application);
        this.repository = repository;
        this.errorMessage = new ObservableField<>();
        isLoading = new ObservableBoolean();
        this.events = PublishSubject.create();
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        loadData();
    }

    @SuppressLint("CheckResult")
    public void loadData() {
        isLoading.set(true);
        disposable = repository.getNewsArticles()
                .map(new ArticleToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onNewsArticlesReceived, this::onNewsArticlesError);
    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> articles) {
        isLoading.set(false);
        newsList.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        errorMessage.set(throwable.getMessage());
        Log.d(getClass().getSimpleName(), throwable.getMessage());
    }

    @Override
    public void onItemClick(ArticleItemViewModel itemViewModel) {
        events.onNext(itemViewModel);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null)
            disposable.dispose();
    }
}
