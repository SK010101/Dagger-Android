package com.skshivamk.omen.advanceandroid.base;

import dagger.Binds;
import dagger.Component;
import dagger.Module;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

}
