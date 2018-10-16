package com.yveschiong.yelpreviews.common.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;

import com.yveschiong.yelpreviews.GlideApp;
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

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView view, String url, Drawable placeholder) {
        GlideApp.with(view).load(url).placeholder(placeholder).into(view);
    }
}
