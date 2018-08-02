package com.zzh.common.mvpdemo.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.zzh.common.mvpdemo.adapter.VideoLoveAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.ILocalPresenter;
import com.zzh.common.mvpdemo.module.manager.love.video.LoveVideoFragment;
import com.zzh.common.mvpdemo.module.manager.love.video.LoveVideoPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Video收藏
 */
@Module
public class LoveVideoModule {

    private final LoveVideoFragment mView;

    public LoveVideoModule(LoveVideoFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public ILocalPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new LoveVideoPresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new VideoLoveAdapter(mView.getContext());
    }
}
