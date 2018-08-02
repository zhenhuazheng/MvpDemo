package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.ViewPagerAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.module.video.main.VideoMainFragment;
import com.zzh.common.mvpdemo.module.video.main.VideoMainPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 视频主界面 Module
 */
@Module
public class VideoMainModule {

    private final VideoMainFragment mView;

    public VideoMainModule(VideoMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideVideosPresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoMainPresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }
}
