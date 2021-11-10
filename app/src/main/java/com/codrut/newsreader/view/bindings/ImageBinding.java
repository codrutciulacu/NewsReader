package com.codrut.newsreader.view.bindings;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBinding {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void setImageUrl(ImageView imageView, String url, @DrawableRes int placeholder) {
        Glide.with(imageView.getContext())
                .load(url)
                .fallback(placeholder)
                .centerCrop()
                .into(imageView);
    }
}
