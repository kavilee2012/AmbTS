package com.lz.www.ambts.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.lz.www.ambts.R;
import com.lz.www.ambts.util.Config;


/**
 * Created by Administrator on 2016-07-07.
 */
public class AmbLogActivity extends Activity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);


        Cursor cursor=getContentResolver().query(Config.AMBLOG_URI,new String[]{"id as _id", "Source","Content"},null,null,null);

        listView=(ListView) findViewById(R.id.lvDao);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.item_list_news,cursor,new String[]{"Source","Content"},new int[]{R.id.tvTitle,R.id.tvContent},0);
        listView.setAdapter(adapter);

    }






}
