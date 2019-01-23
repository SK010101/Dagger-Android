package com.skshivamk.omen.advanceandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.skshivamk.omen.advanceandroid.R;
import com.skshivamk.omen.advanceandroid.base.BaseActivity;
import com.skshivamk.omen.advanceandroid.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
