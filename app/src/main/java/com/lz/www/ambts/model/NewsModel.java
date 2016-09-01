package com.lz.www.ambts.model;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.AdDomain;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.jk.INewsModel;
import com.lz.www.ambts.net.HttpService;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.util.Config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
                           // m.setAddTime(o.getString("AddTime"));
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

    @Override
    public List<AdDomain> getAdList() {
        List<AdDomain> adList = new ArrayList<AdDomain>();

//        AdDomain adDomain = new AdDomain();
//        adDomain.setId("108078");
//        adDomain.setDate("3月4日");
//        adDomain.setTitle("我和令计划只是同姓");
//        adDomain.setTopicFrom("阿宅");
//        adDomain.setTopic("我想知道令狐安和令计划有什么关系？");
//        adDomain.setImgUrl("drawable://" + R.drawable.mn1);
////        adDomain.setImgUrl("http://g.hiphotos.baidu.com/image/w%3D310/sign=bb99d6add2c8a786be2a4c0f5708c9c7/d50735fae6cd7b8900d74cd40c2442a7d9330e29.jpg");
//        adDomain.setAd(false);
//        adList.add(adDomain);
//
//        AdDomain adDomain2 = new AdDomain();
//        adDomain2.setId("108078");
//        adDomain2.setDate("3月5日");
//        adDomain2.setTitle("我和令计划只是同姓");
//        adDomain2.setTopicFrom("小巫");
//        adDomain2.setTopic("“我想知道令狐安和令计划有什么关系？”");
//        adDomain2.setImgUrl("http://g.hiphotos.baidu.com/image/w%3D310/sign=7cbcd7da78f40ad115e4c1e2672e1151/eaf81a4c510fd9f9a1edb58b262dd42a2934a45e.jpg");
//        adDomain2.setAd(false);
//        adList.add(adDomain2);
//
//        AdDomain adDomain3 = new AdDomain();
//        adDomain3.setId("108078");
//        adDomain3.setDate("3月6日");
//        adDomain3.setTitle("我和令计划只是同姓");
//        adDomain3.setTopicFrom("旭东");
//        adDomain3.setTopic("“我想知道令狐安和令计划有什么关系？”");
//        adDomain3.setImgUrl("http://e.hiphotos.baidu.com/image/w%3D310/sign=392ce7f779899e51788e3c1572a6d990/8718367adab44aed22a58aeeb11c8701a08bfbd4.jpg");
//        adDomain3.setAd(false);
//        adList.add(adDomain3);
//
//        AdDomain adDomain4 = new AdDomain();
//        adDomain4.setId("108078");
//        adDomain4.setDate("3月7日");
//        adDomain4.setTitle("我和令计划只是同姓");
//        adDomain4.setTopicFrom("小软");
//        adDomain4.setTopic("“我想知道令狐安和令计划有什么关系？”");
//        adDomain4.setImgUrl("http://d.hiphotos.baidu.com/image/w%3D310/sign=54884c82b78f8c54e3d3c32e0a282dee/a686c9177f3e670932e4cf9338c79f3df9dc55f2.jpg");
//        adDomain4.setAd(false);
//        adList.add(adDomain4);
//
//        AdDomain adDomain5 = new AdDomain();
//        adDomain5.setId("108078");
//        adDomain5.setDate("3月8日");
//        adDomain5.setTitle("我和令计划只是同姓");
//        adDomain5.setTopicFrom("大熊");
//        adDomain5.setTopic("“我想知道令狐安和令计划有什么关系？”");
//        adDomain5.setImgUrl("http://e.hiphotos.baidu.com/image/w%3D310/sign=66270b4fe8c4b7453494b117fffd1e78/0bd162d9f2d3572c7dad11ba8913632762d0c30d.jpg");
//        adDomain5.setAd(true); // 代表是广告
//        adList.add(adDomain5);

        return adList;
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
