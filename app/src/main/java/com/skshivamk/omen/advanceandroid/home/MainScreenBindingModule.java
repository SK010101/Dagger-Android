package com.skshivamk.omen.advanceandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.skshivamk.omen.advanceandroid.di.ControllerKey;
import com.skshivamk.omen.advanceandroid.trending.TrendingReposComponent;
import com.skshivamk.omen.advanceandroid.trending.TrendingReposController;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingInjector(TrendingReposComponent.Builder builder);
}
