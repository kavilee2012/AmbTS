package com.lz.www.ambts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.lz.www.ambts.R;
import com.lz.www.ambts.net.RegisterAsyncTask;
import com.lz.www.ambts.util.Config;


/**
 * Created by Administrator on 2016-05-24.
 */
public class RegisterActivity extends Activity {

    Button btnRegister,btnLogin;
    ProgressBar mPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPB=(ProgressBar)findViewById(R.id.pbRegister);
        mPB.setVisibility(View.INVISIBLE);

        btnRegister = (Button)findViewById(R.id.btnRegisterStart);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tvName=(EditText) findViewById(R.id.etRegisterName);
                EditText tvPwd=(EditText) findViewById(R.id.etRegisterPassword);
                EditText tvEmail=(EditText) findViewById(R.id.etRegisterEmail);

                String name= tvName.getText().toString();
                String pwd=tvPwd.getText().toString();
                String email=tvEmail.getText().toString();

                String url= Config.AMB_API+"act=adduser&name="+name+"&pwd="+pwd+"&img="+email;
                RegisterAsyncTask rat=new RegisterAsyncTask(RegisterActivity.this,mPB,url);
                rat.execute();

               // String re = HttpService.sendGetRequest(url);//4.0以上不能在UI线程执行网络操作
//                if(re=="1")
//                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT);
//                else
//                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT);

            }
        });

        btnLogin = (Button)findViewById(R.id.btnRegisterLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(it);
            }
        });
    }
}
