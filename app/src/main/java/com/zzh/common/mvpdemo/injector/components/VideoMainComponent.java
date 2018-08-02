package com.zzh.common.mvpdemo.injector.components;

import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.VideoMainModule;
import com.zzh.common.mvpdemo.module.video.main.VideoMainFragment;

import dagger.Component;

/**
 *
 * 视频主界面 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoMainModule.class)
public interface VideoMainComponent {
    void inject(VideoMainFragment fragment);
}
