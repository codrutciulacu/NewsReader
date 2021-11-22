package com.codrut.newsreader.view.bindings;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class ViewBinding {

    @BindingAdapter("visible")
    public static void setVisible(View view, boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

}
