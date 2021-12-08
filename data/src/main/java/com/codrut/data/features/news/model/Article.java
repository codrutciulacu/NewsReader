package com.codrut.data.features.news.model;

import androidx.annotation.NonNull;

public class Article {

    public final Integer id;
    @NonNull
    public final String imageUrl;
    @NonNull
    public final String title;
    @NonNull
    public final String content;
    @NonNull
    public final String description;

    public Article(Integer id, @NonNull String imageUrl, @NonNull String title,
                   @NonNull String content, @NonNull String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
