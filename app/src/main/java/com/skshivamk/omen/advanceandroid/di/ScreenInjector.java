package com.skshivamk.omen.advanceandroid.di;

import android.app.Activity;
import com.bluelinelabs.conductor.Controller;
import com.skshivamk.omen.advanceandroid.base.BaseActivity;
import com.skshivamk.omen.advanceandroid.base.BaseController;
import dagger.android.AndroidInjector;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;

@ActivityScope
public class ScreenInjector {

    private final Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector;
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector){
        this.screenInjector = screenInjector;
    }

    void inject(Controller controller){
        if (!(controller instanceof BaseController)){
            throw new IllegalArgumentException("Controller must extend BaseController");
        }

        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)) {
            cache.get(instanceId).inject(controller);
            return;
        }
        //noinspection unchecked
        AndroidInjector.Factory<Controller> injectorFactory =
                (AndroidInjector.Factory<Controller>) screenInjector.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }
    void clear(Controller controller){
        cache.remove(controller.getInstanceId());
    }
    static ScreenInjector get(Activity activity){
        if (!(activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        return ((BaseActivity) activity).getScreenInjector();
    }
}
