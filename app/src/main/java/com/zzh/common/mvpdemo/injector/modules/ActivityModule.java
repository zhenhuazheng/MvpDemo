package com.zzh.common.mvpdemo.injector.modules;

import android.app.Activity;


import com.zzh.common.mvpdemo.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Activity Module
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    Activity getActivity() {
        return mActivity;
    }
}
