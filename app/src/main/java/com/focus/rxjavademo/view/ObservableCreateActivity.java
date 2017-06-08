package com.focus.rxjavademo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.focus.rxjavademo.R;
import com.orhanobut.logger.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


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
                just();
                break;
            case R.id.button_from:
                from();
                break;
            case R.id.button_create:
                create();
                break;
            case R.id.button_range:
                range();
                break;
            case R.id.button_interval:
                interval();
                break;
            default:
        }
    }
    private Disposable mInterval;
    private void interval() {
        mInterval = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribe(aLong -> Logger.d("interval long: " + aLong));
    }

    private void range() {
        mInterval.dispose();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.range(0, list.size())
                .subscribe(i -> Logger.d("range number: %d", list.get(i)));
    }

    private void just() {
        Observable.just("hello android")
                .subscribe(s -> {
                    Logger.d("just character: %s", s);
                });
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .subscribe(i -> Logger.d("just number: %d", i));
    }

    private void from() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.fromIterable(list)
                .subscribe(i -> Logger.d("from number: %d", i));
    }

    private void create() {
        Observable.create(emitter -> {
            emitter.onNext("hello");
            emitter.onNext("world");
            emitter.onComplete();
        }).subscribe(s -> Logger.d("create string: %d" + s));
    }

}
