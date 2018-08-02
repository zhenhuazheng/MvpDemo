package com.zzh.common.mvpdemo.injector.modules;


import com.zzh.common.mvpdemo.adapter.ViewPagerAdapter;
import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.module.manager.love.LoveActivity;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 收藏 Module
 */
@Module
public class LoveModule {

    private final LoveActivity mView;

    public LoveModule(LoveActivity view) {
        this.mView = view;
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }

}
