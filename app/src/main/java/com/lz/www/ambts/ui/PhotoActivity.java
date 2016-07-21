package com.lz.www.ambts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.service.BgMusicService;
import com.lz.www.ambts.ui.adapter.GalleryAdapter;
import com.lz.www.ambts.ui.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016-07-12.
 */
public class PhotoActivity extends Activity {

    private MyRecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        //启动service背景音乐
        Intent intent=new Intent(PhotoActivity.this,BgMusicService.class);
        startService(intent);

        initDatas();
        mRecyclerView=(MyRecyclerView)findViewById(R.id.rvPhoto);
        imageView=(ImageView)findViewById(R.id.imgBigPhoto);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter=new GalleryAdapter(this,mDatas);
        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(PhotoActivity.this, postion + "", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(mDatas.get(postion));
            }
        });


        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                imageView.setImageResource(mDatas.get(position));
            }
        });

    }

    private void initDatas(){
        mDatas=new ArrayList<Integer>(Arrays.asList(R.drawable.mn1,R.drawable.mn2,R.drawable.mn3,R.drawable.mn4,R.drawable.mn5,R.drawable.mn6));
    }


    @Override
    protected void onStop() {
        //停止service
        Intent intent=new Intent(PhotoActivity.this,BgMusicService.class);
        stopService(intent);
        super.onStop();
    }
}
