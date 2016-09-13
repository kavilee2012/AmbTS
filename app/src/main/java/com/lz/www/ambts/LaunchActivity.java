package com.lz.www.ambts;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.lz.www.ambts.ui.HomeActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

//        final AlphaAnimation animation = new AlphaAnimation(0.3f,1.0f);
//        animation.setDuration(3000);//设置动画持续时间
//        animation.start();
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Intent it=new Intent(LaunchActivity.this, HomeActivity.class);
//                startActivity(it);
//                finish();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it=new Intent(LaunchActivity.this, HomeActivity.class);
                startActivity(it);
                finish();
            }
        },3000);

    }
}
