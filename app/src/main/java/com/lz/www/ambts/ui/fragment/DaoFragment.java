package com.lz.www.ambts.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.NewsDetailActivity;
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

    int lastVisibleItem=0;

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.toolTvTitle)
    TextView toolTvTitle;

    @InjectView(R.id.refreshNews)
    SwipeRefreshLayout refreshNews;
    @InjectView(R.id.rvNews)
    public RecyclerView rvNews;

    RecyclerView.LayoutManager mLayoutManager;

//    public NewsAdapter mAdapter = null;
    NewsRvAdapter mAdapter=null;

    private LunboFragment fragment;
    private FragmentManager fm;

    public DaoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    refreshNews.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dao, container, false);
        ButterKnife.inject(this,view);

//        toolbar.setTitle("");
        toolTvTitle.setText("经营理念");


        refreshNews.setColorSchemeColors(R.color.accent,R.color.icons,R.color.colorPrimary,R.color.colorPrimaryDark);
        refreshNews.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });



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

//        mAdapter = new NewsAdapter(mNewsList, getActivity());
//        lvNews.setAdapter(mAdapter);
//        lvNews.setOnItemClickListener(this);


        rvNews.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        mLayoutManager=new LinearLayoutManager(this.getActivity());
        rvNews.setLayoutManager(mLayoutManager);
        mAdapter=new NewsRvAdapter(getActivity(),mNewsList);
        rvNews.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getActivity(), "你点击了第" + i + "项", Toast.LENGTH_SHORT).show();
//
//        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
//        startActivity(it);

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

        mAdapter.mDataList = newNewsList;
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
        private Context mContext;
        private List<News> mDataList;
        private LayoutInflater mLayoutInflater;

        public NewsRvAdapter(Context context, List<News> dataList) {
            this.mContext = context;
            this.mDataList = dataList;
            mLayoutInflater=LayoutInflater.from(context);
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
            bindNewsItem(m,nHolder.txtTitle,nHolder.txtRemark,nHolder.imgIcon);
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public long getItemId(int position) {
            return mDataList.get(position).getId();
        }



        void bindNewsItem(News m, TextView title,TextView remark, ImageView icon){
//            if(m.getImgUrl().isEmpty())
//                icon.setVisibility(View.GONE);
            title.setText(m.getTitle());
            remark.setText(m.getContent());
            icon.setImageDrawable(getResources().getDrawable(R.drawable.qq));
        }


    }

    void showNewsDetails(){
        Intent it = new Intent(getActivity(), NewsDetailActivity.class);
        startActivity(it);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public TextView txtRemark;
        public ImageView imgIcon;

        public NewsViewHolder(View itemView) {
            super(itemView);
            this.txtTitle = (TextView)itemView.findViewById(R.id.news_item_title);
            this.txtRemark = (TextView)itemView.findViewById(R.id.news_item_remark);
            this.imgIcon = (ImageView)itemView.findViewById(R.id.news_item_icon);
            itemView.findViewById(R.id.news_item_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到详细界面
                    showNewsDetails();
                }
            });
        }
    }

}
