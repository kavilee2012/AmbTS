package com.lz.www.ambts.ui.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.lz.www.ambts.model.Point;


/**
 * Created by Administrator on 2016-07-16.
 */
public class MyAnimView extends View {

    public static final float RADIUS = 50f;
    private Point currentPoint;
    private Paint mPaint;

    public MyAnimView(Context context) {
        super(context);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(currentPoint==null){
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        }else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas){
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x,y,RADIUS,mPaint);
    }

    private void startAnimation(){
        Point startPoint = new Point(getWidth()/2, RADIUS);
        Point endPoint = new Point(getWidth()/2, getHeight() - RADIUS);
        final ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentPoint=(Point)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
//        anim.setInterpolator(new AccelerateInterpolator(2f));//加速度，可替换多种形式
        anim.setInterpolator(new BounceInterpolator());//落地后弹起，可替换多种形式
        anim.setDuration(5000);
        anim.start();
    }





    public class PointEvaluator implements TypeEvaluator {
        @Override
        public Object evaluate(float v, Object o, Object t1) {
            Point startP =(Point)o;
            Point endP =(Point)t1;
            float x=startP.getX()+v*(endP.getX()-startP.getX());
            float y=startP.getY()+v*(endP.getY()-startP.getY());
            Point point=new Point(x,y);
            return point;
        }
    }



}
