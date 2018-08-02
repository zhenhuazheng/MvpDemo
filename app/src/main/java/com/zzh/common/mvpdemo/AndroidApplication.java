package com.zzh.common.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.dl7.downloaderlib.DownloadConfig;
import com.dl7.downloaderlib.FileDownloader;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.zzh.common.mvpdemo.greendao.dao.NewsTypeDao;
import com.zzh.common.mvpdemo.greendao.table.DaoMaster;
import com.zzh.common.mvpdemo.greendao.table.DaoSession;
import com.zzh.common.mvpdemo.injector.components.ApplicationComponent;
import com.zzh.common.mvpdemo.injector.components.DaggerApplicationComponent;
import com.zzh.common.mvpdemo.injector.modules.ApplicationModule;
import com.zzh.common.mvpdemo.net.RetrofitService;
import com.zzh.common.mvpdemo.rxbus.RxBus;
import com.zzh.common.mvpdemo.utils.CrashHandler;
import com.zzh.common.mvpdemo.utils.DownloadUtils;
import com.zzh.common.mvpdemo.utils.DownloaderWrapper;
import com.zzh.common.mvpdemo.utils.PreferencesUtils;
import com.zzh.common.mvpdemo.utils.ToastUtils;

import org.greenrobot.greendao.database.Database;

import java.io.File;


public class AndroidApplication extends Application {

    private static final String DB_NAME = "news-db";

    private static ApplicationComponent sAppComponent;
    private static Context sContext;
    private DaoSession mDaoSession;
    // 因为下载那边需要用，这里在外面实例化在通过 ApplicationModule 设置
    private RxBus mRxBus = new RxBus();


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        _initDatabase();
        _initInjector();
        _initConfig();
    }

    /**
     * 使用Tinker生成Application，这里改成静态调用
     * @return
     */
    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }

    /**
     * 初始化注射器
     */
    private void _initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        sAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, mDaoSession, mRxBus))
                .build();
    }

    /**
     * 初始化数据库
     */
    private void _initDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), DB_NAME);
        Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        NewsTypeDao.updateLocalData(getContext(), mDaoSession);
        DownloadUtils.init(mDaoSession.getBeautyPhotoInfoDao());
    }

    /**
     * 初始化配置
     */
    private void _initConfig() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
            Logger.init("LogTAG");
        }
        CrashHandler.getInstance().init(getContext());
        RetrofitService.init();
        ToastUtils.init(getContext());
        DownloaderWrapper.init(mRxBus, mDaoSession.getVideoInfoDao());
        FileDownloader.init(getContext());
        DownloadConfig config = new DownloadConfig.Builder()
                .setDownloadDir(PreferencesUtils.getSavePath(getContext()) + File.separator + "video/").build();
        FileDownloader.setConfig(config);
    }
}
