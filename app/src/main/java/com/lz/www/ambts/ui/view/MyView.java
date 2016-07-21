package com.lz.www.ambts.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016-07-15.
 */
public class MyView extends View {

    private Paint mPaint;  //绘制线条的Path
    private Path mPath;      //记录用户绘制的Path
    private Canvas mCanvas;  //内存中创建的Canvas
    private Bitmap mBitmap;  //缓存绘制的内容

    private int mLastX;
    private int mLastY;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPath=new Path();
        mPaint=new Paint();
        mPaint.setAntiAlias(true);          //抗锯齿
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));//画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);  //画笔风格
        mPaint.setStrokeJoin(Paint.Join.ROUND); //结合处为圆角
        mPaint.setStrokeCap(Paint.Cap.ROUND); // 设置转弯处为圆角
        mPaint.setTextSize(36);             //绘制文字大小，单位px
        mPaint.setStrokeWidth(20);           //画笔粗细
        mPaint.setDither(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=getMeasuredWidth();
        int height=getMeasuredHeight();
        // 初始化bitmap,Canvas
        mBitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        mCanvas=new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
//        canvas.drawCircle(100, 100, 100, mPaint);
//        canvas.drawRect(200, 0, 500, 200, mPaint);
//        canvas.drawText("hi,china!", 700, 200, mPaint);
//
//        Path path = new Path();
//        path.moveTo(500, 0);
//        path.lineTo(550, 100);
//        path.lineTo(600, 0);
//        path.lineTo(650, 200);
//        path.lineTo(700, 0);
//        path.close();
//        canvas.drawPath(path, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                mLastX=x;
                mLastY=y;
                mPath.moveTo(mLastX,mLastY);
                break;
            case MotionEvent.ACTION_MOVE:
                int dx=Math.abs(x-mLastX);
                int dy=Math.abs(y-mLastY);
                if(dx>3||dy>3)
                    mPath.lineTo(x,y);
                mLastX=x;
                mLastY=y;
                break;
        }
        invalidate();
        return true;
    }
}
