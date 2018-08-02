package com.zzh.common.mvpdemo.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;

import com.dl7.downloaderlib.entity.FileInfo;
import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.zzh.common.mvpdemo.R;
import com.zzh.common.mvpdemo.greendao.table.VideoInfo;
import com.zzh.common.mvpdemo.rxbus.RxBus;
import com.zzh.common.mvpdemo.rxbus.events.VideoEvent;
import com.zzh.common.mvpdemo.utils.DownloaderWrapper;

/**
 *
 * video下载适配器基类
 */
public abstract class BaseVideoDLAdapter extends BaseQuickAdapter<VideoInfo> {

    private static final int INVALID_POS = -1;

    protected boolean mIsEditMode = false;
    protected SparseBooleanArray mSparseItemChecked = new SparseBooleanArray();
    protected final RxBus mRxBus;

    public BaseVideoDLAdapter(Context context, RxBus rxBus) {
        super(context);
        mRxBus = rxBus;
    }

    /**
     * 处理选中事件
     * @param position
     * @param isChecked
     */
    protected void _handleCheckedChanged(int position, boolean isChecked) {
        if (position == INVALID_POS) {
            Logger.i(position + "" + isChecked);
            return;
        }
        mSparseItemChecked.put(position, isChecked);
        int checkedCount = 0;
        int checkedStatus;
        for (int i = 0; i < getItemCount(); i++) {
            if (mSparseItemChecked.get(i, false)) {
                checkedCount++;
            }
        }
        if (checkedCount == 0) {
            checkedStatus = VideoEvent.CHECK_NONE;
        } else if (checkedCount == getItemCount()) {
            checkedStatus = VideoEvent.CHECK_ALL;
        } else {
            checkedStatus = VideoEvent.CHECK_SOME;
        }
        // 通知 DownloadActivity 更新界面
        mRxBus.post(new VideoEvent(checkedStatus));
    }


    public boolean isEditMode() {
        return mIsEditMode;
    }

    public void setEditMode(boolean editMode) {
        mIsEditMode = editMode;
        if (!mIsEditMode) {
            mSparseItemChecked.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 切换 Item 的选中状态
     * @param position
     */
    public void toggleItemChecked(int position, BaseViewHolder holder) {
        boolean isChecked = mSparseItemChecked.get(position);
        Logger.d(position+""+!isChecked);
        holder.setChecked(R.id.cb_delete, !isChecked);
        _handleCheckedChanged(position, !isChecked);
        // 如果用 notifyItemChanged()，会有一闪的情况
//        notifyItemChanged(position);
    }

    public void deleteItemChecked() {
        for (int i = mSparseItemChecked.size() - 1; i >= 0; i--) {
            if (mSparseItemChecked.valueAt(i)) {
                DownloaderWrapper.delete(getItem(mSparseItemChecked.keyAt(i)));
                removeItem(mSparseItemChecked.keyAt(i));
                mSparseItemChecked.delete(mSparseItemChecked.keyAt(i));
            }
        }
    }

    public void checkAllOrNone(boolean isChecked) {
        for (int i = 0; i < getItemCount(); i++) {
            mSparseItemChecked.put(i, isChecked);
        }
        notifyDataSetChanged();
    }

    public void updateDownload(FileInfo fileInfo) {
    }
}
