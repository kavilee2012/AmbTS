package com.lz.www.ambts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-05-26.
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AMB.db";//数据库名称
    private static final int DATABASE_VERSION = 1;//数据库版本

    private final String CREATE_TABLE_AmbLog="create table AmbLog(" +
            "ID Integer primary key," +
            "Source text," +
            "Content text," +
            "AddTime date);";

    private Context _context;
    public MySqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this._context = context;
    }

    /**
     * 第一次调用MySqliteHelper时执行，且APP安装好后只执行一次
     * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AmbLog);
        Toast.makeText(_context,"创建成功",Toast.LENGTH_SHORT).show();
    }


    /**
     * 当SQLiteOpenHelper构造函数传入的Version参数大于oldVersion，就会执行该方法
     * */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1:
               // db.execSQL(CREATE_T2);//添加表
            case 2:
              //  db.execSQL("alter table T1 add colum c1 integer");//添加列
            default:

        }
    }
}
