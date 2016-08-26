package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.NewsDetailActivity;
import com.lz.www.ambts.ui.adapter.NewsAdapter;
import com.lz.www.ambts.ui.component.DaggerNewsComponent;
import com.lz.www.ambts.ui.jk.INewsView;
import com.lz.www.ambts.ui.module.NewsModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-06-01.
 */
public class DaoFragment extends Fragment implements AdapterView.OnItemClickListener,INewsView {

    @Inject
    INewsPresenter mPresenter;
//    @InjectView(R.id.lvDao)
//    public ListView lvNews;

    @InjectView(R.id.rvNews)
    public RecyclerView rvNews;

    public NewsAdapter mAdapter = null;

    private LunboFragment fragment;
    private FragmentManager fm;

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
        ButterKnife.inject(this,view);

        showTopImages();//显示轮播图片

        DaggerNewsComponent.builder()
                .newsModule(new NewsModule(this))
                .build()
                .inject(this);

        InitListData(); //初始化数据，测试用

        return view;
    }

    private void InitListData() {
        List<News> mNewsList = new ArrayList<>();
        mNewsList.add(new News(1, "B1", "this is b1"));
        mNewsList.add(new News(2, "B2", "this is b2"));
        mNewsList.add(new News(3, "B3", "this is b3"));
        mNewsList.add(new News(4, "B4", "this is b4"));

        mAdapter = new NewsAdapter(mNewsList, getActivity());
        lvNews.setAdapter(mAdapter);
        lvNews.setOnItemClickListener(this);
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
    public void showTopImages() {
        fm=getFragmentManager();
        fragment=new LunboFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.lunboContainer,fragment).commit();
    }

    @Override
    public void showNewsList(List<News> newNewsList) {
        Toast.makeText(getActivity(),"获取成功",Toast.LENGTH_SHORT).show();

        mAdapter.mNewsList=newNewsList;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        Toast.makeText(getActivity(),"加载中",Toast.LENGTH_SHORT).show();

    }



    @Override
    public void showLoadingError(String msg) {
        Toast.makeText(getActivity(),"发生错误,原因:"+msg,Toast.LENGTH_SHORT).show();
    }


    public class NewsRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private AppCompatActivity mContext;
        private List<News> mDataList;
        private LayoutInflater mLayoutInflater;

        public NewsRvAdapter(AppCompatActivity mContext, List<News> mDataList) {
            this.mContext = mContext;
            this.mDataList = mDataList;
            mLayoutInflater=LayoutInflater.from(mContext);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new NewsViewHolder(mLayoutInflater.inflate(R.layout.item_rv_news,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            News m=mDataList.get(position);
            if(m==null)
                return;
            NewsViewHolder nHolder=(NewsViewHolder)holder;
            bindNewsItem(m,nHolder.txtTitle,nHolder.imgIcon);
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public long getItemId(int position) {
            return mDataList.get(position).getId();
        }



        void bindNewsItem(News m, TextView title, ImageView icon){
            if(m.getImgUrl().isEmpty())
                icon.setVisibility(View.GONE);
            title.setText(m.getTitle());
        }


    }

    void showNewsDetails(){
        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
        startActivity(it);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public ImageView imgIcon;

        public NewsViewHolder(View itemView) {
            super(itemView);
            this.txtTitle = (TextView)itemView.findViewById(R.id.news_item_title);
            this.imgIcon = (ImageView)itemView.findViewById(R.id.news_item_icon);
            itemView.findViewById(R.id.news_item_icon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到详细界面
                    showNewsDetails();
                }
            });
        }
    }

}
