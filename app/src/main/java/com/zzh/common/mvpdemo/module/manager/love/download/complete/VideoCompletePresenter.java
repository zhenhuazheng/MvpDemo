package com.zzh.common.mvpdemo.module.manager.love.download.complete;

import com.dl7.downloaderlib.model.DownloadStatus;
import com.orhanobut.logger.Logger;
import com.zzh.common.mvpdemo.greendao.table.VideoInfo;
import com.zzh.common.mvpdemo.greendao.table.VideoInfoDao;
import com.zzh.common.mvpdemo.module.base.ILocalView;
import com.zzh.common.mvpdemo.module.base.IRxBusPresenter;
import com.zzh.common.mvpdemo.rxbus.RxBus;
import com.zzh.common.mvpdemo.utils.ListUtils;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 *
 * video 缓存完成 Presenter
 */
public class VideoCompletePresenter implements IRxBusPresenter {

    private final ILocalView mView;
    private final VideoInfoDao mDbDao;
    private final RxBus mRxBus;

    public VideoCompletePresenter(ILocalView view, VideoInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
        mDbDao.queryBuilder()
                .where(VideoInfoDao.Properties.DownloadStatus.eq(DownloadStatus.COMPLETE))
                .rx()
                .list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<VideoInfo>>() {
                    @Override
                    public void call(List<VideoInfo> videoList) {
                        if (ListUtils.isEmpty(videoList)) {
                            mView.noData();
                        } else {
                            mView.loadData(videoList);
                        }
                    }
                });
    }

    @Override
    public void getMoreData() {
    }

    @Override
    public <T> void registerRxBus(Class<T> eventType, Action1<T> action) {
        Subscription subscription = mRxBus.doSubscribe(eventType, action, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e(throwable.toString());
            }
        });
        mRxBus.addSubscription(this, subscription);
    }

    @Override
    public void unregisterRxBus() {
        mRxBus.unSubscribe(this);
    }
}
