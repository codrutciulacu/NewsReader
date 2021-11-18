package com.codrut.newsreader.view.bindings;

import android.view.View;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;

public class VisibilityBinding {

    @BindingAdapter("visible")
    public static void setVisible(ProgressBar progressBar, ObservableBoolean value) {
        progressBar.setVisibility(value.get() ? View.VISIBLE : View.GONE);
    }

}
