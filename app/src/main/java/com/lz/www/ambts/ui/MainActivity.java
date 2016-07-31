package com.lz.www.ambts.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;
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
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.util.Config;

import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

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
                Intent it = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(it);
                break;
            case R.id.btnTestQuery:
                tvTest.setText("i am query");
                //构建retrofit实例
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(Config.AMB_API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                IUserService userService=retrofit.create(IUserService.class);
                Call<MyResponse> call=userService.getList();
                call.enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Call<MyResponse> call, retrofit2.Response<MyResponse> response) {
                        if(response.isSuccess()){
                            List<News> users=response.body().getData();
                            Toast.makeText(MainActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
                            tvTest.setText(response.body().getMsg().toString());
                        }else {
                            Toast.makeText(MainActivity.this,"获取失败",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<MyResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"发生异常",Toast.LENGTH_SHORT).show();
                    }
                });



                break;
            case R.id.btnTestAA:
                tvTest.setText("i am AA");
                Intent itx =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(itx);
                break;
            default:
                tvTest.setText("null");
                break;
        }

    }
}
