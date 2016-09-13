package com.lz.www.ambts.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Attend;
import com.lz.www.ambts.model.bean.Notice;
import com.lz.www.ambts.util.LocalData;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NoticeActivity extends AppCompatActivity {

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.rvNotice)
    RecyclerView rvNotice;

    NoticeRvAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ButterKnife.inject(this);

        mLayoutManager=new LinearLayoutManager(this);
        rvNotice.setLayoutManager(mLayoutManager);
        mAdapter=new NoticeRvAdapter(this, LocalData.getNoticeList());
        rvNotice.setAdapter(mAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public class NoticeRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private Context mContext;
        private List<Notice> mDataList;
        private LayoutInflater mLayoutInflater;

        public NoticeRvAdapter(Context context, List<Notice> dataList) {
            this.mContext = context;
            this.mDataList = dataList;
            mLayoutInflater=LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new NoticeViewHolder(mLayoutInflater.inflate(R.layout.item_rv_notice,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Notice m = mDataList.get(position);
            if (m == null)
                return;
            NoticeViewHolder h = (NoticeViewHolder) holder;
            h.notice=m;
            h.txtTitle.setText(m.getTitle());
            h.txtUser.setText("发布者：" + m.getAddUser());
            h.txtTime.setText("发布时间：" + m.getAddTime());
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public long getItemId(int position) {
            return mDataList.get(position).getID();
        }

    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {

        public Notice notice;

        public TextView txtTitle;
        public TextView txtUser;
        public TextView txtTime;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            this.txtTitle = (TextView)itemView.findViewById(R.id.notice_item_title);
            this.txtUser = (TextView)itemView.findViewById(R.id.notice_item_user);
            this.txtTime = (TextView)itemView.findViewById(R.id.notice_item_time);

            itemView.findViewById(R.id.notice_item_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到详细界面
                    new AlertDialog.Builder(view.getContext())
                            .setTitle(notice.getTitle())
                            .setMessage(notice.getContent())
                            .setNegativeButton("关闭",null)
                            .show();
                }
            });
        }
    }
}
