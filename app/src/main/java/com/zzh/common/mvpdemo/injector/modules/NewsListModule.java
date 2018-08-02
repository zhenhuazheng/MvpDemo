package com.zzh.common.mvpdemo.injector.modules;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.zzh.common.mvpdemo.adapter.NewsMultiListAdapter;
import com.zzh.common.mvpdemo.injector.PerFragment;
import com.zzh.common.mvpdemo.module.base.IBasePresenter;
import com.zzh.common.mvpdemo.module.news.newslist.NewsListFragment;
import com.zzh.common.mvpdemo.module.news.newslist.NewsListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 新闻列表 Module
 */
@Module
public class NewsListModule {

    private final NewsListFragment mNewsListView;
    private final String mNewsId;

    public NewsListModule(NewsListFragment view, String newsId) {
        this.mNewsListView = view;
        this.mNewsId = newsId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new NewsListPresenter(mNewsListView, mNewsId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new NewsMultiListAdapter(mNewsListView.getContext());
    }
}
