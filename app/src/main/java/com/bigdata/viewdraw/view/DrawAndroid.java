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
 * Date:2017/5/31 or 上午9:33
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawAndroid extends View {

    Paint mPaint;

    public DrawAndroid(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(0xFFA4C739);
    }

    public DrawAndroid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(0xFFA4C739);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画机器人头部
        @SuppressLint("DrawAllocation")
        RectF mRecf = new RectF(getMeasuredWidth() / 2 - 300, getMeasuredHeight() / 2 - 300, getMeasuredWidth() / 2 + 100, getMeasuredHeight() / 2 + 100);
        mRecf.offset(100, 20);
        canvas.drawArc(mRecf, -10, -160, false, mPaint);


        //画眼睛
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(getMeasuredWidth() / 2 - 100, getMeasuredHeight() / 2 - 200, 8, mPaint);
        canvas.drawCircle(getMeasuredWidth() / 2 + 100, getMeasuredHeight() / 2 - 200, 8, mPaint);
        //画两根天线
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(20);

        canvas.drawLine(getMeasuredWidth() / 2 - 150, getMeasuredHeight() / 2 - 300, getMeasuredWidth() / 2 - 100, getMeasuredHeight() / 2 - 230, mPaint);
        canvas.drawLine(getMeasuredWidth() / 2 + 150, getMeasuredHeight() / 2 - 300, getMeasuredWidth() / 2 + 100, getMeasuredHeight() / 2 - 230, mPaint);

        mPaint.setColor(Color.RED);
        //画身子
        @SuppressLint("DrawAllocation")
        RectF rectF1 = new RectF(getMeasuredWidth() / 2 - 200, getMeasuredHeight() / 2 - 100, getMeasuredWidth() / 2 + 200, getMeasuredHeight() / 2 + 200);
        canvas.drawRoundRect(rectF1, 10, 10, mPaint);
        //写文字
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(100);
        canvas.drawText("小坤", getMeasuredWidth() / 2-100, getMeasuredHeight() / 2+80, mPaint);
        //画腿
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(getMeasuredWidth() / 2 - 150, getMeasuredHeight() / 2 + 150, getMeasuredWidth() / 2 - 50, (float) (getMeasuredHeight()*0.75));
        canvas.drawRoundRect(rectF, 20, 20, mPaint);
        rectF.offset(200, 0);
        canvas.drawRoundRect(rectF, 20, 20, mPaint);

        mPaint.setColor(Color.BLUE);
        //画胳膊
        @SuppressLint("DrawAllocation")
        RectF rectF2 = new RectF(getMeasuredWidth() / 2 - 270, getMeasuredHeight() / 2 - 100, getMeasuredWidth() / 2 - 220, getMeasuredHeight() / 2 + 200);
        canvas.drawRoundRect(rectF2, 20, 20, mPaint);
        rectF2.offset(490, 0);
        canvas.drawRoundRect(rectF2, 20, 20, mPaint);

        @SuppressLint("DrawAllocation")
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,getMeasuredWidth()/2-50,paint);
    }
}
