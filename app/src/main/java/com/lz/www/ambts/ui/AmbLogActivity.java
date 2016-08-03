package com.lz.www.ambts.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.AmbLog;
import com.lz.www.ambts.model.jk.ILogService;
import com.lz.www.ambts.presenter.jk.ILogPresenter;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.component.DaggerLogComponent;
import com.lz.www.ambts.ui.jk.ILogView;
import com.lz.www.ambts.ui.module.LogModule;
import com.lz.www.ambts.util.Config;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016-07-07.
 */
public class AmbLogActivity extends AppCompatActivity implements ILogView {

    @Inject
    ILogPresenter mPresenter;

    @InjectView(R.id.lvDao)
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);

        ButterKnife.inject(this);
        DaggerLogComponent.builder()
                .logModule(new LogModule(this))
                .build()
                .inject(this);

        mPresenter.start();

    }


    @Override
    public void showLogList(Cursor cursor) {
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.item_list_news,
                cursor,
                new String[]{"Source","Content"},
                new int[]{R.id.tvTitle,R.id.tvContent},
                0);
        listView.setAdapter(adapter);
    }

    @Override
    public void showLogInfo(AmbLog log) {
       new AlertDialog.Builder(this)
               .setTitle("日志详细")
               .setMessage(log.getContent())
               .setPositiveButton("关闭",null)
               .show();
    }

    @Override
    public void showSuccess(int type,String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (type == 0) {
        } else {
            mPresenter.start();//重新加载
        }
    }

    @Override
    public void showFail(int type,String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (type == 0) {
        } else {

        }
    }
}
