package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.ui.adapter.FaAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-06-23.
 */
public class ReportFragment extends Fragment {
    private ArrayList<BigSorts> groupList = null;
    private ArrayList<ArrayList<SubSorts>> subListList = null;
    private ArrayList<SubSorts> subList = null;
    private Context mContext;
    private ExpandableListView elvFa;
    private FaAdapter faAdapter = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa_report,container,false);

        mContext=getActivity();
        elvFa=(ExpandableListView) view.findViewById(R.id.elvFa);

        //数据准备
        groupList = new ArrayList<BigSorts>();
        groupList.add(new BigSorts("收入"));
        groupList.add(new BigSorts("费用"));
        groupList.add(new BigSorts("利润"));

        subListList = new ArrayList<ArrayList<SubSorts>>();

        subList = new ArrayList<SubSorts>();

        //收入组
        subList.add(new SubSorts("001","A商品销售"));
        subList.add(new SubSorts("002","B商品销售"));
        subList.add(new SubSorts("003","C商品销售"));
        subListList.add(subList);

        //费用组
        subList = new ArrayList<SubSorts>();
        subList.add(new SubSorts("001","变动费用"));
        subList.add(new SubSorts("002","固定费用"));
        subList.add(new SubSorts("003","人工成本"));
        subListList.add(subList);

        //利润组
        subList = new ArrayList<SubSorts>();
        subList.add(new SubSorts("001","销售利润"));
        subList.add(new SubSorts("002","节约利润"));
        subList.add(new SubSorts("003","固定资产"));
        subListList.add(subList);

        faAdapter=new FaAdapter(groupList,subListList,mContext);
        elvFa.setAdapter(faAdapter);

        elvFa.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(mContext, "你点击了：" + subListList.get(i).get(i1).getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return view;
    }
}
