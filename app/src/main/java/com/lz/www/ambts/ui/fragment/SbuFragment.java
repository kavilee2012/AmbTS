package com.lz.www.ambts.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.ui.adapter.FaAdapter;
import com.lz.www.ambts.ui.component.DaggerReportComponent;
import com.lz.www.ambts.ui.component.DaggerSbuComponent;
import com.lz.www.ambts.ui.jk.ISbuView;
import com.lz.www.ambts.ui.module.ReportModule;
import com.lz.www.ambts.ui.module.SbuModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SbuFragment extends Fragment implements ISbuView {

    @Inject
    ISbuPresenter mPresenter;


    @InjectView(R.id.rvSbu)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager mLayoutManager;
    SbuRvAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa_sbu,container,false);

        ButterKnife.inject(this,view);



        DaggerSbuComponent.builder()
                .sbuModule(new SbuModule(this))
                .build()
                .inject(this);

        mLayoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        mPresenter.start();

        return view;
    }

    @Override
    public void showAllList(ArrayList<SBU> list) {
        mAdapter = new SbuRvAdapter(getContext(), list);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoadError() {

    }

    public class SbuRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private Context mContext;
        private List<SBU> mDataList;
        private LayoutInflater mLayoutInflater;

        public SbuRvAdapter(Context context, List<SBU> dataList) {
            this.mContext = context;
            this.mDataList = dataList;
            mLayoutInflater=LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SbuViewHolder(mLayoutInflater.inflate(R.layout.item_rv_sbu,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            SBU m=mDataList.get(position);
            if(m==null)
                return;
            SbuViewHolder nHolder=(SbuViewHolder) holder;
            bindItem(m,nHolder.txtName,nHolder.txtHeader,nHolder.txtCount);
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public long getItemId(int position) {
            return mDataList.get(position).getId();
        }



        void bindItem(SBU m, TextView name,TextView header, TextView count){
//            if(m.getImgUrl().isEmpty())
//                icon.setVisibility(View.GONE);
            name.setText(m.getName());
            header.setText("巴长：" + m.getHeader());
            count.setText(String.valueOf("成员数：" + m.getMemberCount()));
        }


    }

    class SbuViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtHeader;
        public TextView txtCount;

        public SbuViewHolder(View itemView) {
            super(itemView);
            this.txtName = (TextView)itemView.findViewById(R.id.sbu_item_name);
            this.txtHeader = (TextView)itemView.findViewById(R.id.sbu_item_header);
            this.txtCount = (TextView) itemView.findViewById(R.id.sbu_item_count);
            itemView.findViewById(R.id.sbu_item_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到详细界面
                }
            });
        }
    }

}
