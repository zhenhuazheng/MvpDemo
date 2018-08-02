package com.zzh.common.mvpdemo.module.news.newslist;


import com.zzh.common.mvpdemo.adapter.NewsMultiItem;
import com.zzh.common.mvpdemo.module.base.ILoadDataView;
import com.zzh.common.mvpdemo.net.bean.NewsInfo;

import java.util.List;

/**
 *
 * 新闻列表视图接口
 */
public interface INewsListView extends ILoadDataView<List<NewsMultiItem>> {

    /**
     * 加载广告数据
     * @param newsBean 新闻
     */
    void loadAdData(NewsInfo newsBean);
}
