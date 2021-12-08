package com.codrut.newsreader.feature.newslist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.codrut.newsreader.R;
import com.codrut.newsreader.feature.newslist.fragment.NewsListFragment;
import com.codrut.newsreader.feature.newslist.model.NewsListViewModel;
import com.codrut.newsreader.feature.newslist.model.factory.NewsListViewModelFactory;
import com.codrut.newsreader.feature.newslist.navigation.ArticleNavigator;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public ArticleNavigator articleNavigator;
    public NewsListViewModel newsListViewModel;
    private Disposable disposable;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        articleNavigator = new ArticleNavigator(getSupportFragmentManager());
        NewsListViewModelFactory factory = new NewsListViewModelFactory(getApplication());
        newsListViewModel = new ViewModelProvider(this, factory).get(NewsListViewModel.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }

        disposable = newsListViewModel.events.subscribe(itemViewModel -> articleNavigator.onShowDetailsEventHandler(itemViewModel),
                throwable -> Log.e(TAG, throwable.getMessage()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}

