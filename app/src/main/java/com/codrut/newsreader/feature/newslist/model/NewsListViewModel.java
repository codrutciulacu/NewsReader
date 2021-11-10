package com.codrut.newsreader.feature.newslist.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

import com.codrut.newsreader.feature.newslist.listener.NewsHandler;

public class NewsListViewModel extends ViewModel implements NewsHandler, DefaultLifecycleObserver {

    public ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        loadData();
    }

    public void loadData() {
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
        newsList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/d/dc/Skyscrapers_of_Shinjuku_2009_January_%28revised%29.jpg", "Something important happened!", "Something very important happened in a very well known city! The peoples around are shocked by what this citizen did!"));
    }

    @Override
    public void onItemClick() {
        Log.d(this.getClass().getSimpleName(), "Item is clicked");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
