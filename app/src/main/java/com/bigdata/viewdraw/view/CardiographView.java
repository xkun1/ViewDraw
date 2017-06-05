package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * user:kun
 * Date:2017/6/5 or 上午10:02
 * email:hekun@gamil.com
 * Desc:  心电图
 */

public class CardiographView extends View {

    private Paint mPaint;
    private int mLineColor = Color.parseColor("#76f112");
    protected int mGridColor = Color.parseColor("#1b4200");

    //小网格颜色
    private int mSgridColor = Color.parseColor("#092100");

    private int mBackGroundColor = Color.BLACK;

    private int mWidth, mHeight;

    private int mGridWidth = 50;

    private int mSGridWidth = 10;

    private Path mPath;


    public CardiographView(Context context) {
        super(context);
    }

    public CardiographView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initBackGround(canvas);
        drawPath(canvas);
    }

    private void drawPath(Canvas canvas) {
        mPath.reset();
        mPath.moveTo(0,mHeight/2);
        int tmp=0;
        for (int i = 0; i <10 ; i++) {
            mPath.lineTo(tmp+20,100);
            mPath.lineTo(tmp+70,mHeight/2+50);
            mPath.lineTo(tmp+80,mHeight/2);
            mPath.lineTo(tmp+200,mHeight/2);
            tmp=tmp+200;
        }
        //设置画笔style
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(mPath,mPaint);

        scrollBy(1,0);
        postInvalidateDelayed(10);
    }

    private void initBackGround(Canvas canvas) {
        canvas.drawColor(mBackGroundColor);
        int vSum = mWidth / mSGridWidth;
        int hSum = mHeight / mSGridWidth;
        mPaint.setColor(mSgridColor);
        mPaint.setStrokeWidth(2);
        for (int i = 0; i < vSum + 1; i++) {
            canvas.drawLine(i * mSGridWidth, 0, i * mSGridWidth, mHeight, mPaint);
        }
        for (int i = 0; i < hSum + 1; i++) {
            canvas.drawLine(0, i * mSGridWidth, mWidth, i * mSGridWidth, mPaint);
        }
        int vNum = mWidth / mGridWidth;
        int hNum = mHeight / mGridWidth;

        mPaint.setColor(mGridColor);
        mPaint.setStrokeWidth(2);

        for (int i = 0; i < vNum; i++) {
            canvas.drawLine(i * mGridWidth, 0, i * mGridWidth, mHeight, mPaint);
        }
        for (int i = 0; i < hNum; i++) {
            canvas.drawLine(0, i * mGridWidth, mWidth, i * mGridWidth, mPaint);
        }
    }

}
