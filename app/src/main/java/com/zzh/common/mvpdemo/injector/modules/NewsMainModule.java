package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.ViewPagerAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.module.news.main.NewsMainFragment;
import com.zzh.common.mvpdemo.module.news.main.NewsMainPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 新闻主页 Module
 */
@Module
public class NewsMainModule {

    private final NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideMainPresenter(DaoSession daoSession, RxBus rxBus) {
        return new NewsMainPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }
}
