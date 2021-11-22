package com.codrut.data.features.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM articles")
    Single<List<ArticleEntity>> getArticles();

    @Query("SELECT * FROM articles WHERE id = :id")
    Single<ArticleEntity> getArticleById(int id);

    @Query("DELETE FROM articles WHERE id = :id")
    Completable deleteArticle(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);
}
