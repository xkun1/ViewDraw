package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
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
 * Date:2017/6/1 or 下午5:18
 * email:hekun@gamil.com
 * Desc:
 */

public class HeartView extends View {
    private int mMeasureWidth;
    private int mMesureHigth;
    private int mWidthMode;
    private int mHigthMode;
    private int heartColor = Color.RED;
    private Paint mPaint;

    public HeartView(Context context) {
        super(context);
        mPaint = new Paint();

    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mWidthMode = MeasureSpec.getMode(widthMeasureSpec);

        mMesureHigth = MeasureSpec.getSize(heightMeasureSpec);
        mHigthMode = MeasureSpec.getMode(heightMeasureSpec);
        if (mWidthMode == MeasureSpec.AT_MOST && mHigthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200);
        } else if (mWidthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, mMesureHigth);
        } else if (mHigthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mMeasureWidth, 200);
        } else {
            setMeasuredDimension(mMeasureWidth, mMesureHigth);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(6);
        mPaint.setColor(heartColor);
        int width = getWidth();
        int height = getHeight();

        @SuppressLint("DrawAllocation")
        Path mPath = new Path();
        mPath.moveTo(width / 2, height / 4);
        mPath.cubicTo((width * 6) / 7, height / 9, (width * 12) / 13, (height * 2) / 5, width / 2, (height * 7) / 12);
        canvas.drawPath(mPath, mPaint);

        @SuppressLint("DrawAllocation")
        Path mPath2 = new Path();
        mPath2.moveTo(width / 2, height / 4);
        mPath2.cubicTo(width / 7, height / 9, width / 13, (height * 2) / 5, width / 2, (height * 7) / 12);
        canvas.drawPath(mPath2, mPaint);

        mPaint.setTextSize(100);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("小坤", width / 2 - 100, height / 3 + 100, mPaint);

    }
}
