package com.lz.www.ambts.model;

import android.database.Cursor;

import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.model.bean.AmbLog;
import com.lz.www.ambts.model.jk.ILogService;
import com.lz.www.ambts.util.Config;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class LogModel implements ILogService {
    @Override
    public int add(AmbLog log) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public AmbLog getOne(int id) {
        return null;
    }

    @Override
    public Cursor getList() {
        Cursor cursor= AppApplication.getContextObject().getContentResolver().query(Config.AMBLOG_URI,new String[]{"id as _id", "Source","Content"},null,null,null);
        return cursor;
    }
}
