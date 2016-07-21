package com.lz.www.ambts.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-06-06.
 */
public class FaAdapter extends BaseExpandableListAdapter {
    private ArrayList<BigSorts> groupList;
    private ArrayList<ArrayList<SubSorts>> itemList;
    private Context mContext;

    public FaAdapter(ArrayList<BigSorts> gData, ArrayList<ArrayList<SubSorts>> iData, Context mContext) {
        this.groupList = gData;
        this.itemList = iData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return itemList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return itemList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup holderGroup;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_elist_fa_group,viewGroup,false);
            holderGroup=new ViewHolderGroup();
            holderGroup.tv_group_name=(TextView)view.findViewById(R.id.tvGroupName);
            view.setTag(holderGroup);
        }else {
            holderGroup=(ViewHolderGroup)view.getTag();
        }
        holderGroup.tv_group_name.setText(groupList.get(i).getName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderItem holderItem;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_elist_fa_sub,viewGroup,false);
            holderItem=new ViewHolderItem();
            //holderItem.img_icon=(ImageView) view.findViewById(R.id.ivChildImg);
            holderItem.tv_name=(TextView)view.findViewById(R.id.tvChildName);
            view.setTag(holderItem);
        }else {
            holderItem=(ViewHolderItem) view.getTag();
        }
        //holderItem.img_icon.setImageResource(itemList.get(i).get(i1).getUri());
        holderItem.tv_name.setText(itemList.get(i).get(i1).getName());

        return view;
    }


    private static class ViewHolderGroup{
        private TextView tv_group_name;
    }

    private static class ViewHolderItem{
        //private ImageView img_icon;
        private TextView tv_name;
    }


}


