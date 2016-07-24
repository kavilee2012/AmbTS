package com.lz.www.ambts.model;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.jk.INewsModel;
import com.lz.www.ambts.net.HttpService;
import com.lz.www.ambts.util.Config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/23.
 */
public class NewsModel implements INewsModel {

    @Override
    public void getNewsList(final LoadNewsListCallback callback) {
        new AsyncTask<Void,Integer,String>(){
            @Override
            protected String doInBackground(Void... params) {
                String url = Config.NewsAPI + "getlist";
                String re = HttpService.doGet(url);
                return re;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    ArrayList<News> newsList=new ArrayList<News>();
                    JSONObject jsonObject = new JSONObject(s);
                    String count=jsonObject.getString("count");
                    if(!count.equals("0") && !count.isEmpty()) {
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            News m = new News();
                            JSONObject o = jsonArray.getJSONObject(i);
                            m.setId(o.getInt("ID"));
                            m.setTitle(o.getString("Title"));
                            m.setContent(o.getString("Content"));
                            m.setUrl(o.getString("Url"));
                            m.setAuthor(o.getString("Author"));
                            m.setAddTime(o.getString("AddTime"));
                            m.setTop(o.getBoolean("IsTop"));
                            m.setImgUrl(o.getString("ImgUrl"));
                            newsList.add(m);
                        }
//                        mAdapter.mNewsList = newsList;//(ArrayList<News>) response.getList();
//                        mAdapter.notifyDataSetChanged();
                        callback.onSuccess(newsList);
                    }
                    else {
                        //Toast.makeText(getActivity(),"获取新闻列表失败",Toast.LENGTH_SHORT).show();
                        callback.onFail("获取新闻列表失败");
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                    callback.onFail("异常："+ex.getMessage());
                }
            }
        }.execute();
    }

    @Override
    public ArrayList<Bitmap> getTopImages() {
        return null;
    }

    /*
       *异步调用HTTP类
       *三个泛型参数含义<doInBackground传入参数类型,onProgressUpdate传入参数类型,onPostExecute传入参数类型>

    class NewsAsyncTask extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String url = Config.NewsAPI + "getlist";
            //Config.UserAPI + "getlist"
            // http://apis.baidu.com/apistore/iplookup/iplookup_paid
            String re = HttpService.doGet(url);
            return re;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                ArrayList<News> newsList=new ArrayList<News>();
                JSONObject jsonObject = new JSONObject(s);
                String count=jsonObject.getString("count");
                if(!count.equals("0") && !count.isEmpty()) {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        News m = new News();
                        JSONObject o = jsonArray.getJSONObject(i);
                        m.setId(o.getInt("ID"));
                        m.setTitle(o.getString("Title"));
                        m.setContent(o.getString("Content"));
                        m.setUrl(o.getString("Url"));
                        m.setAuthor(o.getString("Author"));
                        m.setAddTime(o.getString("AddTime"));
                        m.setTop(o.getBoolean("IsTop"));
                        m.setImgUrl(o.getString("ImgUrl"));
                        newsList.add(m);
                    }
                    mAdapter.mNewsList = newsList;//(ArrayList<News>) response.getList();
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getActivity(),"获取新闻列表失败",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    */
}
