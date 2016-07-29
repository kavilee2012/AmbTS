package com.lz.www.ambts.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lz.www.ambts.R;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.util.Config;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tvTestView)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.btnTestQuery,R.id.btnTestAA,R.id.btnOpenLogin})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.btnOpenLogin:
                Intent it = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(it);
                break;
            case R.id.btnTestQuery:
                tvTest.setText("i am query");
                //构建retrofit实例
                Retrofit retrofit=new Retrofit.Builder().baseUrl(Config.AMB_API).addConverterFactory(GsonConverterFactory.create()).build();
                IUserService userService=retrofit.create(IUserService.class);
                Call<String> call=userService.getOne("kavilee2012");
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                        if(response.isSuccess()){
                            Toast.makeText(MainActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
                            tvTest.setText(response.body().toString());
                        }else {
                            Toast.makeText(MainActivity.this,"获取失败",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"发生异常",Toast.LENGTH_SHORT).show();
                    }
                });



                break;
            case R.id.btnTestAA:
                tvTest.setText("i am AA");
                break;
            default:
                tvTest.setText("null");
                break;
        }

    }
}
