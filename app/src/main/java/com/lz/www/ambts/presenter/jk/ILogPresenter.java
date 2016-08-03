package com.lz.www.ambts.presenter.jk;

import com.lz.www.ambts.model.bean.AmbLog;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface ILogPresenter extends IBasePresenter {

    void loadLogList();

    void loadLogOne(int id);

    void addLog(AmbLog log);

    void deleteLog(int id);


}
