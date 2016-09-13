package com.lz.www.ambts.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Attend;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.util.Config;
import com.lz.www.ambts.util.LocalData;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AttendActivity extends AppCompatActivity {

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.rvAttend)
    RecyclerView rvAttend;

    AttendRvAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend);
        ButterKnife.inject(this);

        mLayoutManager=new LinearLayoutManager(this);
        rvAttend.setLayoutManager(mLayoutManager);
        mAdapter=new AttendRvAdapter(this, LocalData.getAttendList());
        rvAttend.setAdapter(mAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public class AttendRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private Context mContext;
        private List<Attend> mDataList;
        private LayoutInflater mLayoutInflater;

        public AttendRvAdapter(Context context, List<Attend> dataList) {
            this.mContext = context;
            this.mDataList = dataList;
            mLayoutInflater=LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AttendViewHolder(mLayoutInflater.inflate(R.layout.item_rv_attend,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Attend m = mDataList.get(position);
            if (m == null)
                return;
            AttendViewHolder h = (AttendViewHolder) holder;
            h.txtDate.setText(m.getDateDisplay());
            h.txtShouldDays.setText("应出勤天数：" + String.valueOf(m.getShouldDays()));
            h.txtActualDays.setText("实际出勤天数：" + String.valueOf(m.getActualDays()));
            h.txtLateCount.setText("迟到次数：" + String.valueOf(m.getLateCount()));
            h.txtLeaveCount.setText("请假次数：" + String.valueOf(m.getLeaveCount()));
            h.txtAbsentCount.setText("旷工次数：" + String.valueOf(m.getAbsentCount()));
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

    class AttendViewHolder extends RecyclerView.ViewHolder {
//        @InjectView(R.id.item_date)
        public TextView txtDate;
//        @InjectView(R.id.item_shouldDays)
        public TextView txtShouldDays;
//        @InjectView(R.id.item_actualDays)
        public TextView txtActualDays;
//        @InjectView(R.id.item_late)
        public TextView txtLateCount;
//        @InjectView(R.id.item_leave)
        public TextView txtLeaveCount;
//        @InjectView(R.id.item_absent)
        public TextView txtAbsentCount;

        public AttendViewHolder(View itemView) {
            super(itemView);
            this.txtDate = (TextView)itemView.findViewById(R.id.item_date);
            this.txtShouldDays = (TextView)itemView.findViewById(R.id.item_shouldDays);
            this.txtActualDays = (TextView)itemView.findViewById(R.id.item_actualDays);
            this.txtLateCount = (TextView)itemView.findViewById(R.id.item_late);
            this.txtLeaveCount=(TextView)itemView.findViewById(R.id.item_leave);
            this.txtAbsentCount=(TextView)itemView.findViewById(R.id.item_absent);
//            ButterKnife.inject(this,itemView);
        }
    }

}
