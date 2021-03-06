package com.skshivamk.omen.advanceandroid.base;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bluelinelabs.conductor.Controller;
import com.skshivamk.omen.advanceandroid.di.Injector;

public abstract class BaseController extends Controller {

    private Boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        if (!injected){
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);


    }
}
