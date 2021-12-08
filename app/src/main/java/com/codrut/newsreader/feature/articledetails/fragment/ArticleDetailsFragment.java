package com.codrut.newsreader.feature.articledetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.codrut.newsreader.databinding.ArticleDetailsFragmentBinding;
import com.codrut.newsreader.feature.articledetails.model.ArticleDetailsViewModel;
import com.codrut.newsreader.feature.articledetails.model.factory.ArticleDetailsViewModelFactory;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

public class ArticleDetailsFragment extends Fragment {

    public static final String EXTRA_ARTICLE_ITEM = "articleItem";
    private ArticleDetailsViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArticleDetailsViewModelFactory factory = new ArticleDetailsViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(ArticleDetailsViewModel.class);

        if (getArguments() != null && getArguments().containsKey(EXTRA_ARTICLE_ITEM)) {
            viewModel.itemViewModel = (ArticleItemViewModel) getArguments().get(EXTRA_ARTICLE_ITEM);
        }

        getLifecycle().addObserver(viewModel);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleDetailsFragmentBinding binding = ArticleDetailsFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}