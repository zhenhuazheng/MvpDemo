package com.zzh.common.mvpdemo.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.zzh.common.mvpdemo.adapter.BeautyPhotosAdapter;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.ILocalPresenter;
import com.zzh.common.mvpdemo.module.manager.love.photo.LovePhotoFragment;
import com.zzh.common.mvpdemo.module.manager.love.photo.LovePhotoPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 图片收藏界面 Module
 */
@Module
public class LovePhotoModule {

    private final LovePhotoFragment mView;

    public LovePhotoModule(LovePhotoFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public ILocalPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new LovePhotoPresenter(mView, daoSession.getBeautyPhotoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new BeautyPhotosAdapter(mView);
    }
}
