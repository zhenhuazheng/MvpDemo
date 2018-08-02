package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.LoveVideoModule;
import com.zzh.common.mvpdemo.module.manager.love.video.LoveVideoFragment;

import dagger.Component;

/**
 *
 * Video收藏 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LoveVideoModule.class)
public interface LoveVideoComponent {
    void inject(LoveVideoFragment fragment);
}
