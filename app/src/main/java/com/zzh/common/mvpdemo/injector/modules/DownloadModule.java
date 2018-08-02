package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.ViewPagerAdapter;
import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.module.manager.love.download.DownloadActivity;
import com.zzh.common.mvpdemo.module.manager.love.download.DownloadPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * video下载Module
 */
@Module
public class DownloadModule {

    private final DownloadActivity mView;

    public DownloadModule(DownloadActivity view) {
        mView = view;
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }

    @PerActivity
    @Provides
    public IRxBusPresenter provideVideosPresenter(RxBus rxBus) {
        return new DownloadPresenter(rxBus);
    }
}
