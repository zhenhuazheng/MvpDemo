package com.zzh.common.mvpdemo.injector.components;

import android.app.Activity;

import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.injector.modules.ActivityModule;

import dagger.Component;

/**
 *
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
