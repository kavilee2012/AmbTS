package com.lz.www.ambts.ui.jk;

import android.database.Cursor;

import com.lz.www.ambts.model.bean.AmbLog;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface ILogView {

    void  showLogList(Cursor cursor);

    void showLogInfo(AmbLog log);

    void showSuccess(int type,String msg);

    void showFail(int type,String msg);
}
