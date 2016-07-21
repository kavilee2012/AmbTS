package com.lz.www.ambts.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.lz.www.ambts.db.MySqliteHelper;


/**
 * Created by Administrator on 2016-07-06.
 */
public class LogProvider extends ContentProvider {

    private final static String AUTHORITY="com.lz.www.ambrm.ContentProvider.LogProvider";
    private final static int LOGS=1; //返回多个
    private final static int LOG=2; //返回一个
    private MySqliteHelper sqliteHelper;

    private static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        matcher.addURI(AUTHORITY,"AmbLog",LOGS);
        matcher.addURI(AUTHORITY,"AmbLog/#",LOG);
    }

    /**
     * 第一次访问ContentProvider的时候调用，该方法只会被调用一次
     * */
    @Override
    public boolean onCreate() {
        sqliteHelper=new MySqliteHelper(this.getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] columns, String where, String[] whereArgs, String orderBy) {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        switch (matcher.match(uri)) {
            case LOGS:
                return db.query("AmbLog",columns,where,whereArgs,null,null,orderBy);
            case LOG:
                long id= ContentUris.parseId(uri);
                String whereClause="ID="+id;
                if(where!=null&&!"".equals(where)) {
                    whereClause += " and " + where;
                }
                return db.query("AmbLog",columns,whereClause,whereArgs,null,null,orderBy);
            default:
                throw new IllegalArgumentException("未知URI：" + uri);
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (matcher.match(uri)) {
            case LOGS:
                return "AAAAAAA";
            case LOG:
                return "BBBBBBB";
            default:
                throw new IllegalArgumentException("未知URI：" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        switch (matcher.match(uri)){
            case LOGS:
                long rowid=db.insert("AmbLog","ID",contentValues);
                if(rowid>0){
                    Uri newUri=ContentUris.withAppendedId(uri,rowid);
                    getContext().getContentResolver().notifyChange(newUri,null);
                    return newUri;
                }
                break;
            default:
                throw new IllegalArgumentException("未知URI：" + uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        int num = 0;
        switch (matcher.match(uri)) {
            case LOGS:
                num = db.delete("AmbLog", where, whereArgs);
                break;
            case LOG:
                long id = ContentUris.parseId(uri);
                String whereClause = "ID=" + id;
                if (where != null && "".equals(where)) {
                    whereClause += " and " + where;
                }
                num = db.delete("AmbLog", whereClause, whereArgs);
                break;
            default:
                throw new IllegalArgumentException("未知URI：" + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return num;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
