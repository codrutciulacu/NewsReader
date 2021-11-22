package com.codrut.newsreader.feature.newslist.model;

import androidx.lifecycle.ViewModel;

import com.codrut.newsreader.R;

public class ArticleItemViewModel extends ViewModel {

    public final String pictureUrl;
    public final String title;
    public final String contentPreview;
    public final int placeholder;

    public ArticleItemViewModel(String pictureUrl, String title, String contentPreview) {
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.contentPreview = contentPreview;
        this.placeholder = R.drawable.placeholder;
    }
}
