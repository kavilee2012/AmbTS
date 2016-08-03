package com.lz.www.ambts.presenter;

import android.database.Cursor;

import com.lz.www.ambts.model.bean.AmbLog;
import com.lz.www.ambts.model.jk.ILogService;
import com.lz.www.ambts.presenter.jk.ILogPresenter;
import com.lz.www.ambts.ui.jk.ILogView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class LogPresenter implements ILogPresenter {

    ILogView mView;
    ILogService mModel;

    public LogPresenter(ILogView mView, ILogService mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void loadLogList() {
        Cursor cursor=mModel.getList();
        mView.showLogList(cursor);
    }

    @Override
    public void loadLogOne(int id) {
        AmbLog log=mModel.getOne(id);
        mView.showLogInfo(log);
    }

    @Override
    public void addLog(AmbLog log) {

    }

    @Override
    public void deleteLog(int id) {
        int re=mModel.delete(id);
        if(re>0){
            mView.showSuccess(1,"删除成功!");
        }else {
            mView.showFail(1,"删除失败!");
        }
    }

    @Override
    public void start() {
        loadLogList();
    }
}
