package com.zzh.common.mvpdemo.injector.components;

import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.NewsMainModule;
import com.zzh.common.mvpdemo.module.news.main.NewsMainFragment;

import dagger.Component;

/**
 *
 * 主页 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsMainModule.class)
public interface NewsMainComponent {
    void inject(NewsMainFragment fragment);
}
