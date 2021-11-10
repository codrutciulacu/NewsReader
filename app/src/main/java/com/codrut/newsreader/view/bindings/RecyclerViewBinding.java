package com.codrut.newsreader.view.bindings;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codrut.newsreader.feature.newslist.adapter.NewsAdapter;
import com.codrut.newsreader.feature.newslist.listener.NewsHandler;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerViewBinding {

    @BindingAdapter({"items", "articleHandler"})
    public static void setItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles, NewsHandler handler) {
        NewsAdapter adapter = (NewsAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new NewsAdapter(handler);
            LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        adapter.setItems(articles);
        Log.d("RecyclerViewBinding", "" + recyclerView.getAdapter().getItemCount());
    }
}
