package com.zzh.common.mvpdemo.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.zzh.common.mvpdemo.adapter.VideoListAdapter;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IBasePresenter;
import com.zzh.common.mvpdemo.module.video.list.VideoListFragment;
import com.zzh.common.mvpdemo.module.video.list.VideoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * video列表
 */
@Module
public class VideoListModule {

    private final VideoListFragment mView;
    private final String mVideoId;

    public VideoListModule(VideoListFragment view, String videoId) {
        this.mView = view;
        this.mVideoId = videoId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new VideoListPresenter(mView, mVideoId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new VideoListAdapter(mView.getContext());
    }
}
