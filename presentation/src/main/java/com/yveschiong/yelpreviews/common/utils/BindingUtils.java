package com.yveschiong.yelpreviews.common.utils;

import android.databinding.BindingAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yveschiong.yelpreviews.common.utils.view.TextChange;
import com.yveschiong.yelpreviews.common.utils.view.TextChangeWatcher;

public class BindingUtils {
    @BindingAdapter("textChange")
    public static void textChange(final EditText editText, final TextChange textChange) {
        editText.addTextChangedListener(new TextChangeWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textChange.onChange(charSequence.toString());
            }
        });
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }
}
