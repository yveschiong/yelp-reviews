package com.yveschiong.yelpreviews.common.utils;

import android.databinding.BindingAdapter;
import android.widget.EditText;

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
}
