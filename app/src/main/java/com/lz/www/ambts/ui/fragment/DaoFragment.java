package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.News;
import com.lz.www.ambts.net.HttpService;
import com.lz.www.ambts.ui.NewsDetailActivity;
import com.lz.www.ambts.ui.adapter.NewsAdapter;
import com.lz.www.ambts.util.Config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-06-01.
 */
public class DaoFragment extends Fragment implements AdapterView.OnItemClickListener {

    public ArrayList<News> mNewsList = null;
    public NewsAdapter mAdapter = null;
    public ListView lvNews;
    private TextView btnToList;

    public DaoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dao, container, false);

        mNewsList = new ArrayList<News>();
        mNewsList.add(new News(1, "B1", "this is b1"));
//        mNewsList.add(new News(2, "B2", "this is b2", R.drawable.b2));
//        mNewsList.add(new News(3, "B3", "this is b3", R.drawable.b3));
//        mNewsList.add(new News(4, "B4", "this is b4", R.drawable.b4));

        mAdapter = new NewsAdapter(mNewsList, getActivity());
        lvNews = (ListView) view.findViewById(R.id.lvDao);
        lvNews.setAdapter(mAdapter);
        lvNews.setOnItemClickListener(this);

        NewsAsyncTask nat=new NewsAsyncTask();
        nat.execute();


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), "你点击了第" + i + "项", Toast.LENGTH_SHORT).show();

        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
        startActivity(it);

    }

    /*
    *异步调用HTTP类
    *三个泛型参数含义<doInBackground传入参数类型,onProgressUpdate传入参数类型,onPostExecute传入参数类型>
    */
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
}
