package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.BaseVideoDLAdapter;
import com.zzh.common.mvpdemo.adapter.VideoCompleteAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.module.manager.love.download.complete.VideoCompleteFragment;
import com.zzh.common.mvpdemo.module.manager.love.download.complete.VideoCompletePresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * video 缓存完成 Module
 */
@Module
public class VideoCompleteModule {

    private final VideoCompleteFragment mView;

    public VideoCompleteModule(VideoCompleteFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoCompletePresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseVideoDLAdapter provideAdapter(RxBus rxBus) {
        return new VideoCompleteAdapter(mView.getContext(), rxBus);
    }
}
