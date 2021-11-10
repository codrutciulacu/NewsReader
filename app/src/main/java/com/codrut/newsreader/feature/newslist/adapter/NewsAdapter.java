package com.codrut.newsreader.feature.newslist.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codrut.newsreader.databinding.ArticleListItemBinding;
import com.codrut.newsreader.feature.newslist.listener.NewsHandler;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final NewsHandler handler;
    private List<ArticleItemViewModel> articleModelList;


    public NewsAdapter(NewsHandler handler) {
        this.handler = handler;
        articleModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleListItemBinding binding = ArticleListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.setViewModel(articleModelList.get(position));
        holder.binding.setHandler(handler);
    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<ArticleItemViewModel> items) {
        this.articleModelList = items;
        notifyDataSetChanged();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private final ArticleListItemBinding binding;

        public NewsViewHolder(ArticleListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
