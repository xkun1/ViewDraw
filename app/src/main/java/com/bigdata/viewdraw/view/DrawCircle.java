package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * user:kun
 * Date:2017/5/28 or 下午5:37
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawCircle extends View {
    private Paint mPaint;

    private String mTitle="KUN";
    public DrawCircle(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }

    public DrawCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (float) (getMeasuredWidth()*0.5)/ 2, mPaint);
        Paint paint1=new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(50);
        RectF rectF = new RectF(
                (float) ((float) getMeasuredWidth() * 0.1),
                (float) ((float) getMeasuredWidth() * 0.1),
                (float) ((float) getMeasuredWidth()*0.8),
                (float) ((float) getMeasuredWidth()*0.8));
        canvas.drawArc(rectF,270,270,false,paint1);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        canvas.drawText(mTitle,0,mTitle.length(),getMeasuredWidth()/2,getMeasuredWidth()/2+(mTitle.length()+4),paint);
    }
}
