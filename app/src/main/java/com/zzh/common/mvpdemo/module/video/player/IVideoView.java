package com.zzh.common.mvpdemo.module.video.player;


import com.zzh.common.mvpdemo.greendao.table.VideoInfo;
import com.zzh.common.mvpdemo.module.base.IBaseView;

import java.io.InputStream;

/**
 *
 * Video接口
 */
public interface IVideoView extends IBaseView {

    /**
     * 获取Video数据
     * @param data 数据
     */
    void loadData(VideoInfo data);

    /**
     * 获取弹幕数据
     * @param inputStream 数据
     */
    void loadDanmakuData(InputStream inputStream);

}
