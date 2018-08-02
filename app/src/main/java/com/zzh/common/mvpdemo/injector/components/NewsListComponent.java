package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.NewsListModule;
import com.zzh.common.mvpdemo.module.news.newslist.NewsListFragment;

import dagger.Component;

/**
 *
 * 新闻列表 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsListModule.class)
public interface NewsListComponent {
    void inject(NewsListFragment fragment);
}
