package com.focus.rxjavademo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.focus.rxjavademo.R;

import io.reactivex.Observable;

/**
 * Created by focus on 17/6/7.
 */

public class ObservableCreateActivity extends AppCompatActivity {
    private TextView mTextShow;
    private static final String TAG = "Observable";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_create);
        mTextShow = (TextView) findViewById(R.id.text_show);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_just:

                break;
            default:
        }
    }

    private void just() {
        Observable.just("hello android")
                .subscribe(s -> {
                    Log.d(TAG, "just character: " + s);
                    Log.d(TAG, "");
                });
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .subscribe( i -> Log.d(TAG, "just number arrays: " + i));

    }
}
