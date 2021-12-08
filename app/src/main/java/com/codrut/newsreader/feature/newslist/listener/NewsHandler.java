package com.codrut.newsreader.feature.newslist.listener;

import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

public interface NewsHandler {
    void onItemClick(ArticleItemViewModel itemViewModel);
}
