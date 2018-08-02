package com.zzh.common.mvpdemo.injector.components;

import android.content.Context;

import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.modules.ApplicationModule;
import com.zzh.common.mvpdemo.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 * Application Component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(BaseActivity baseActivity);

    // provide
    Context getContext();
    RxBus getRxBus();
    DaoSession getDaoSession();
}
