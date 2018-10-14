package com.yveschiong.yelpreviews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchFilterFragment.newInstance())
                    .commitNow();
        }
    }
}
