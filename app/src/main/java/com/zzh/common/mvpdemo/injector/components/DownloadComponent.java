package com.zzh.common.mvpdemo.injector.components;

import com.zzh.common.mvpdemo.injector.PerActivity;
import com.zzh.common.mvpdemo.injector.modules.DownloadModule;
import com.zzh.common.mvpdemo.module.manager.love.download.DownloadActivity;

import dagger.Component;

/**
 *
 * video下载 Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = DownloadModule.class)
public interface DownloadComponent {
    void inject(DownloadActivity activity);
}
