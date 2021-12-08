package com.codrut.newsreader.feature.newslist.model;

import androidx.lifecycle.ViewModel;

import com.codrut.newsreader.R;

import java.io.Serializable;

public class ArticleItemViewModel extends ViewModel implements Serializable {

    public final Integer id;
    public final String pictureUrl;
    public final String title;
    public final String contentPreview;
    public final String content;
    public final int placeholder;

    public ArticleItemViewModel(Integer id, String pictureUrl, String title, String contentPreview, String content) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.title = title;
        this.contentPreview = contentPreview;
        this.content = content;
        this.placeholder = R.drawable.placeholder;
    }
}
