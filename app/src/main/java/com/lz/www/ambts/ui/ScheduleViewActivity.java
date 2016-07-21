package com.lz.www.ambts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lz.www.ambts.R;


/**
 * Created by Administrator on 2016-07-11.
 */
public class ScheduleViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_text);
        TextView tvContent=(TextView)findViewById(R.id.tvShowText);
        tvContent.setText(this.getIntent().getStringExtra("content"));
        //返回
        Button btnCancel=(Button)findViewById(R.id.btnGoBack);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
