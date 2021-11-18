package com.codrut.newsreader.feature.newslist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.codrut.newsreader.R;
import com.codrut.newsreader.feature.newslist.fragment.NewsListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}

