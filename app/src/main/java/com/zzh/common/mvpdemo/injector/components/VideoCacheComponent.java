package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.VideoCacheModule;
import com.zzh.common.mvpdemo.module.manager.love.download.cache.VideoCacheFragment;

import dagger.Component;

/**
 *
 * video缓存Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoCacheModule.class)
public interface VideoCacheComponent {
    void inject(VideoCacheFragment fragment);
}
