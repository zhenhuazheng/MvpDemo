package com.zzh.common.mvpdemo.injector.components;

import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.injector.modules.LoveModule;

import dagger.Component;

/**
 *
 * 收藏 Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = LoveModule.class)
public interface LoveComponent {
//    void inject(LoveActivity activity);
}
