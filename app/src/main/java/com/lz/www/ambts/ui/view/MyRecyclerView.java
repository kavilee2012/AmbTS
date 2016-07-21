package com.lz.www.ambts.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Administrator on 2016-07-15.
 */
public class MyRecyclerView extends RecyclerView {

    public interface OnItemScrollChangeListener{
        void onChange(View view, int position);
    }

    private View mCurrentView;
    private OnItemScrollChangeListener  mItemScrollChangeListener;
    public void setOnItemScrollChangeListener(OnItemScrollChangeListener itemScrollChangeListener){
        this.mItemScrollChangeListener=itemScrollChangeListener;
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView,dx,dy);
                View newView=getChildAt(0);
                if(mItemScrollChangeListener!=null){
                    if(newView!=null&&newView!=mCurrentView){
                        mCurrentView=newView;
                        mItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        mCurrentView=getChildAt(0);
        if(mItemScrollChangeListener!=null){
            mItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
        }

    }

}
