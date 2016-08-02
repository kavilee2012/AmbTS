package com.lz.www.ambts.model.jk;

import android.database.Cursor;

import com.lz.www.ambts.model.bean.AmbLog;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface ILogService {

    int add(AmbLog log);

    int delete(int id);

    AmbLog getOne(int id);

    Cursor getList();
}
