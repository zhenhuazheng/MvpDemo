package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.VideoListModule;
import com.zzh.common.mvpdemo.module.video.list.VideoListFragment;

import dagger.Component;

/**
 *
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoListModule.class)
public interface VideoListComponent {
    void inject(VideoListFragment fragment);
}
