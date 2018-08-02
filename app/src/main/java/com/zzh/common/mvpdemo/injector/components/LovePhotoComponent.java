package com.zzh.common.mvpdemo.injector.components;


import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.injector.modules.LovePhotoModule;
import com.zzh.common.mvpdemo.module.manager.love.photo.LovePhotoFragment;

import dagger.Component;

/**
 *
 * 图片收藏界面 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LovePhotoModule.class)
public interface LovePhotoComponent {
    void inject(LovePhotoFragment fragment);
}
