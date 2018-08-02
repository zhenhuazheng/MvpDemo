package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.injector.modules.VideoPlayerModule;
import com.zzh.common.mvpdemo.module.video.player.VideoPlayerActivity;

import dagger.Component;

/**
 *
 * Video Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = VideoPlayerModule.class)
public interface VideoPlayerComponent {
    void inject(VideoPlayerActivity activity);
}
