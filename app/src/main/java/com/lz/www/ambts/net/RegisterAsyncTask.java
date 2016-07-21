package com.lz.www.ambts.net;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-05-31.
 */
public class RegisterAsyncTask extends AsyncTask<String,Integer,String> {

    ProgressBar mPB;
    String mURL;
    Context mContext;


    public RegisterAsyncTask(Context context, ProgressBar pb, String url) {
        super();
        this.mPB = pb;
        this.mURL=url;
        this.mContext=context;
    }

    @Override
    protected void onPreExecute() {
//        Toast.makeText(this,"准备开始注册",Toast.LENGTH_SHORT);
        mPB.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... strings) {
        String re="";
        try {
            for (int i=0;i<10;i++){
                Thread.sleep(2000);
                publishProgress(i);
            }
            re = HttpService.doGet(mURL);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return re;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        mPB.setProgress(values[0]);

    }

    @Override
    protected void onPostExecute(String s) {
        mPB.setVisibility(View.INVISIBLE);

        AlertDialog.Builder dialog=new AlertDialog.Builder(mContext);
        dialog.setTitle("注册结果");
        dialog.setMessage("返回值:"+s.toString());
        dialog.show();

        if (s.equals("1")){
            Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(mContext, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }
}
