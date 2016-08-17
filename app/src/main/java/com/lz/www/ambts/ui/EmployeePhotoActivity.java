package com.lz.www.ambts.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.fragment.ListPhotoFragment;

/**
 * Created by Administrator on 2016-08-17.
 */
public class EmployeePhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeephoto);

        FragmentManager fm = getFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.photoContainer);
        if(fragment==null){
            fragment=new ListPhotoFragment();
            fm.beginTransaction().add(R.id.photoContainer,fragment).commit();
        }
    }
}
