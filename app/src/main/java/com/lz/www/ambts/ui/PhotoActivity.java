package com.lz.www.ambts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.R;
import com.lz.www.ambts.service.BgMusicService;
import com.lz.www.ambts.ui.adapter.GalleryAdapter;
import com.lz.www.ambts.ui.view.MyRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-07-12.
 */
public class PhotoActivity extends AppCompatActivity {


    Menu mMenu;

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.rvPhoto)
    MyRecyclerView mRecyclerView;
    @InjectView(R.id.imgBigPhoto)
    ImageView imageView;

    LinearLayoutManager linearLayoutManager;

    private GalleryAdapter mAdapter;
//    private List<Integer> mDatas;
    private List<String> mImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ButterKnife.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        StartMusicService();


        initDatas();

        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter=new GalleryAdapter(this,mImages);
        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int postion) {
//                Toast.makeText(PhotoActivity.this, postion + "", Toast.LENGTH_SHORT).show();
//                imageView.setImageResource(mDatas.get(postion));
                Picasso.with(AppApplication.getContextObject()).load(mImages.get(postion)).placeholder(R.drawable.pictures_no).error(R.drawable.pictures_no).into(imageView);

            }
        });


        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
//                imageView.setImageResource(mDatas.get(position));
                Picasso.with(AppApplication.getContextObject()).load(mImages.get(position)).placeholder(R.drawable.pictures_no).error(R.drawable.pictures_no).into(imageView);

            }
        });

    }

    private void initDatas(){
//        mDatas=new ArrayList<Integer>(Arrays.asList(R.drawable.mn1,R.drawable.mn2,R.drawable.mn3,R.drawable.mn4,R.drawable.mn5,R.drawable.mn6));
        mImages=Arrays.asList(getResources().getStringArray(R.array.photo)) ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu=menu;

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_close_music,menu);

        showStopMenu();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCloseMusic:
                StopMusicService();
                break;
            case R.id.menuStartMusic:
                StartMusicService();
                break;
        }
        return true;
    }

    private void showStartMenu(){
        if(mMenu!=null){
            mMenu.getItem(0).setEnabled(true);
            mMenu.getItem(0).setVisible(true);

            mMenu.getItem(1).setEnabled(false);
            mMenu.getItem(1).setVisible(false);
        }
    }

    private void showStopMenu(){
        if(mMenu!=null) {
            mMenu.getItem(0).setEnabled(false);
            mMenu.getItem(0).setVisible(false);

            mMenu.getItem(1).setEnabled(true);
            mMenu.getItem(1).setVisible(true);
        }
    }

    //播放音乐
    private void StartMusicService() {
        Intent intent=new Intent(PhotoActivity.this,BgMusicService.class);
        startService(intent);
        showStopMenu();
    }

    //停止音乐
    private void StopMusicService() {
        Intent intent=new Intent(PhotoActivity.this,BgMusicService.class);
        stopService(intent);
        showStartMenu();
    }




    @Override
    protected void onStop() {
        //停止service
        StopMusicService();
        super.onStop();
    }
}
