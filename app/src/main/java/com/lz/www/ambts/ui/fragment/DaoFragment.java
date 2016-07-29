package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.presenter.NewsPresenter;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.NewsDetailActivity;
import com.lz.www.ambts.ui.adapter.NewsAdapter;
import com.lz.www.ambts.ui.jk.INewsView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-06-01.
 */
public class DaoFragment extends Fragment implements AdapterView.OnItemClickListener,INewsView {

    INewsPresenter mPresenter;
    public NewsAdapter mAdapter = null;
    public ListView lvNews;

    public DaoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new NewsPresenter(this);//初始化
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dao, container, false);

        lvNews = (ListView) view.findViewById(R.id.lvDao);
        ArrayList<News>  mNewsList = new ArrayList<>();
        mNewsList.add(new News(1, "B1", "this is b1"));
        mNewsList.add(new News(2, "B2", "this is b2"));
        mNewsList.add(new News(3, "B3", "this is b3"));
        mNewsList.add(new News(4, "B4", "this is b4"));

        mAdapter = new NewsAdapter(mNewsList, getActivity());
        lvNews.setAdapter(mAdapter);
        lvNews.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), "你点击了第" + i + "项", Toast.LENGTH_SHORT).show();

        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
        startActivity(it);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {
        mPresenter=(INewsPresenter) presenter;
    }

    @Override
    public void showTopImages() {

    }

    @Override
    public void showNewsList(ArrayList<News> newNewsList) {
        mAdapter.mNewsList=newNewsList;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadingError(String msg) {
        Toast.makeText(getActivity(),"发生错误,原因:"+msg,Toast.LENGTH_SHORT).show();
    }

}
