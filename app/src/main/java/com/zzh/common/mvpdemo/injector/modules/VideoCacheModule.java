package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.BaseVideoDLAdapter;
import com.zzh.common.mvpdemo.adapter.VideoCacheAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.module.manager.love.download.cache.VideoCacheFragment;
import com.zzh.common.mvpdemo.module.manager.love.download.cache.VideoCachePresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * video缓存Module
 */
@Module
public class VideoCacheModule {

    private final VideoCacheFragment mView;

    public VideoCacheModule(VideoCacheFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoCachePresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseVideoDLAdapter provideAdapter(RxBus rxBus) {
        return new VideoCacheAdapter(mView.getContext(), rxBus);
    }
}
