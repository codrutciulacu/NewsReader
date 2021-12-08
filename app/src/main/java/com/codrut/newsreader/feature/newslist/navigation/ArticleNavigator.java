package com.codrut.newsreader.feature.newslist.navigation;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.codrut.newsreader.R;
import com.codrut.newsreader.feature.articledetails.fragment.ArticleDetailsFragment;
import com.codrut.newsreader.feature.newslist.model.ArticleItemViewModel;

public class ArticleNavigator {
    private final FragmentManager fragmentManager;


    public ArticleNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onShowDetailsEventHandler(ArticleItemViewModel itemViewModel) {
        ArticleDetailsFragment fragment = new ArticleDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ArticleDetailsFragment.EXTRA_ARTICLE_ITEM, itemViewModel);
        fragment.setArguments(bundle);

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment, ArticleDetailsFragment.class.getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
