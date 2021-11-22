package com.codrut.data.features.news.local;

import static java.util.stream.Collectors.toList;

import com.codrut.data.features.news.local.mapper.ArticleToEntityMapper;
import com.codrut.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class NewsLocalDataStore {

    private final ArticleDao newsDao;
    private final ArticleToEntityMapper mapper;

    public NewsLocalDataStore(ArticleDao newsDao, ArticleToEntityMapper mapper) {
        this.newsDao = newsDao;
        this.mapper = mapper;
    }

    public Single<List<Article>> getArticleList() {
        return newsDao.getArticles().map(list -> list.stream().map(mapper::entityToArticle).collect(toList()));
    }

    public Single<Article> getArticleById(int id) {
        return newsDao.getArticleById(id).map(mapper::entityToArticle);
    }

    public Completable deleteArticle(int id) {
        return newsDao.deleteArticle(id);
    }

    public Completable deleteAllArticles() {
        return newsDao.deleteAllArticles();
    }

    public Completable insertArticles(List<Article> articles) {
        return newsDao.insertArticles(articles.stream().map(mapper::articleToEntity).collect(toList()));
    }

    public Completable insertArticle(Article article) {
        return newsDao.insertArticle(mapper.articleToEntity(article));
    }
}
