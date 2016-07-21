package com.lz.www.ambts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.lz.www.ambts.ui.view.MyAnimView;

/**
 * Created by Administrator on 2016-07-16.
 */
public class AnimationActivity extends Activity {

    TextView txtContent;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_animation);
        setContentView(new MyAnimView(this));
//        txtContent=(TextView)findViewById(R.id.txtAnimation);
//        btnStart=(Button)findViewById(R.id.btnStart);
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                ObjectAnimator animatorMove=ObjectAnimator.ofFloat(txtContent,"translationX",-500f,0f);
////                ObjectAnimator animatorTurn=ObjectAnimator.ofFloat(txtContent,"rotation",0f,360f);
////                ObjectAnimator animatorAlpha=ObjectAnimator.ofFloat(txtContent,"alpha",1f,0f,1f);
////                AnimatorSet animatorSet=new AnimatorSet();
////                animatorSet.play(animatorTurn).with(animatorAlpha).after(animatorMove);
////                animatorSet.setDuration(5000);
////                animatorSet.start();
//
//            }
//        });
    }



}
