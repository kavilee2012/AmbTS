package com.lz.www.ambts.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.lz.www.ambts.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tvTestView)
    TextView tvTest;
    @InjectView(R.id.myTool)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        toolbar.setTitle("阿米巴");
        toolbar.setSubtitle("welcome to my company!");
//        toolbar.setLogo(R.drawable.qq);
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.left);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @OnClick({R.id.btnTestQuery,R.id.btnTestAA,R.id.btnOpenLogin})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.btnOpenLogin:
                Intent it = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(it);
                break;
            case R.id.btnTestQuery:
//                tvTest.setText("i am query");
//                //构建retrofit实例
//                Retrofit retrofit=new Retrofit.Builder()
//                        .baseUrl(Config.AMB_API)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                IUserService userService=retrofit.create(IUserService.class);
//                Call<MyResponse> call=userService.getList();
//                call.enqueue(new Callback<MyResponse>() {
//                    @Override
//                    public void onResponse(Call<MyResponse> call, retrofit2.Response<MyResponse> response) {
//                        if(response.isSuccess()){
//                            Object obj=response.body().getData();
//                            List<News> users=(List<News>) obj;
//                            Toast.makeText(MainActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
//                            tvTest.setText(response.body().getMsg().toString());
//                        }else {
//                            Toast.makeText(MainActivity.this,"获取失败",Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<MyResponse> call, Throwable t) {
//                        Toast.makeText(MainActivity.this,"发生异常",Toast.LENGTH_SHORT).show();
//                    }
//                });
//


                break;
            case R.id.btnTestAA:
                tvTest.setText("i am AA");
                Intent itx =new Intent(MainActivity.this,LunBoActivity.class);
                startActivity(itx);
                break;
            default:
                tvTest.setText("null");
                break;
        }

    }
}
