package com.codrut.data.remote;

import com.codrut.data.features.news.remote.model.ArticleListDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v2/top-headlines")
    Single<ArticleListDto> getNewsArticles(@Query("apiKey") String apiKey, @Query("language") String enLanguageFilter);
}
