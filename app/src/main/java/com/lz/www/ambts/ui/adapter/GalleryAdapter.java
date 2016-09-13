package com.lz.www.ambts.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016-07-14.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    public interface OnItemClickLitener{
        void onItemClick(View view, int postion);
    }

    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener){
        this.mOnItemClickLitener=onItemClickLitener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView mImg;
        TextView mTxt;
    }

    private LayoutInflater mInflater;
    private List<String> mDatas;

    public GalleryAdapter(Context context, List<String> datas){
        mInflater=LayoutInflater.from(context);
        mDatas=datas;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_photo,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.mImg=(ImageView)view.findViewById(R.id.imgPhoto);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.mImg.setImageResource(mDatas.get(position));
        Picasso.with(AppApplication.getContextObject()).load(mDatas.get(position)).placeholder(R.drawable.pictures_no).error(R.drawable.pictures_no).into(holder.mImg);
        if(mOnItemClickLitener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickLitener.onItemClick(holder.itemView,position);
                }
            });
        }


    }
}
