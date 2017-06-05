package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * user:kun
 * Date:2017/6/2 or 上午9:49
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawRecf extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    public DrawRecf(Context context) {
        super(context);
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }

    public DrawRecf(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=MeasureSpec.getSize(widthMeasureSpec);
        mHeight=MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2,mHeight/2);
        @SuppressLint("DrawAllocation")
        RectF rectF=new RectF(-400,-400,400,400);
        for (int i = 0; i <20 ; i++) {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rectF,mPaint);
        }
    }
}
