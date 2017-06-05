package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * user:kun
 * Date:2017/5/27 or 下午6:03
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawView extends View {
    private Context mContext;
    private Paint mPaint;

    private int mWidth;
    private int mHeight;

    public DrawView(Context context) {
        super(context);
        this.mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//设置画笔无锯齿
        mPaint.setTextSize(50);
        this.setKeepScreenOn(true);//背景常亮
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//设置画笔无锯齿
        mPaint.setTextSize(50);
        this.setKeepScreenOn(true);//背景常亮
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float[] ps = {
                0,0,mWidth/2,mHeight/2,
                mWidth,0,mWidth/2,mHeight/2,
                0,mHeight,mWidth/2,mHeight/2,
                mWidth,mHeight,mWidth/2,mHeight/2,
                100, mHeight / 2, mWidth / 2 - 100, mHeight / 2,
                mWidth / 2 + 100, mHeight / 2, mWidth - 100, mHeight / 2,
                mWidth / 2, 100, mWidth / 2, mHeight / 2 - 100,
                mWidth / 2, mHeight / 2 + 100, mWidth / 2, mHeight - 100,
                mWidth / 2 - 100, mHeight / 2, mWidth / 2, mHeight / 2 - 100,
                mWidth / 2, mHeight / 2 - 100, mWidth / 2 + 100, mHeight / 2,
                mWidth / 2 + 100, mHeight / 2, mWidth / 2, mHeight / 2 + 100,
                mWidth / 2, mHeight / 2 + 100, mWidth / 2 - 100, mHeight / 2};
        canvas.drawLines(ps, mPaint);

        canvas.drawCircle(mWidth / 2 - 200, mHeight / 2, 100, mPaint);
        canvas.drawCircle(mWidth / 2, mHeight / 2 - 200, 100, mPaint);
        canvas.drawCircle(mWidth / 2 + 200, mHeight / 2, 100, mPaint);
        canvas.drawCircle(mWidth / 2, mHeight / 2 + 200, 100, mPaint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        Log.d("KUN", "onMeasure: mWidth==" + mWidth);
        Log.d("KUN", "onMeasure: mHeight==" + mHeight);
    }
}
