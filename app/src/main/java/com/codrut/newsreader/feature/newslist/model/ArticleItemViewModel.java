package com.codrut.newsreader.feature.newslist.model;

import androidx.lifecycle.ViewModel;

import com.codrut.newsreader.R;

public class ArticleItemViewModel extends ViewModel {

    public String pictureUrl;
    public String title;
    public String contentPreview;
    public int placeholder;

    public ArticleItemViewModel() {
    }

    public ArticleItemViewModel(String pictureUrl, String title, String contentPreview) {
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.contentPreview = contentPreview;
        this.placeholder = R.drawable.placeholder;
    }
}
