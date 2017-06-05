package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * user:kun
 * Date:2017/6/2 or 下午1:23
 * email:hekun@gamil.com
 * Desc:  使用贝塞尔曲线画图
 */

public class DrawBezier extends View {
    private Paint mPaint;
    private Paint mPaint2;
    private int centerX;
    private int centerY;
    private Bitmap mBitmap;
    private int r = 200;
    private float rote = 30;

    public DrawBezier(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint2 = new Paint();
        mBitmap = Bitmap.createBitmap(400, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(mBitmap);
        mPaint2.setStrokeWidth(20);
        canvas1.drawLine(centerX, centerY, centerX, centerY + 600, mPaint2);
    }


    public DrawBezier(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint2 = new Paint();

        mBitmap = Bitmap.createBitmap(400, 800, Bitmap.Config.ARGB_8888);

        Canvas canvas1 = new Canvas(mBitmap);
        mPaint2.setStrokeWidth(20);
        canvas1.drawLine(centerX, centerY, centerX, centerY + 600, mPaint2);
    }

    public void statrt(){
        while (true){
            rote = rote + 10;
            postInvalidate();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        rote = rote + 10;

        postInvalidate();

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, centerX - 5, centerY, mPaint);
        canvas.rotate(rote, centerX, centerY);
        super.onDraw(canvas);

        @SuppressLint("DrawAllocat")
        Path mPath = new Path();
        mPath.moveTo(centerX - r, centerY - r);  //起始点
        mPath.cubicTo(centerX + r, centerY - r, centerX - r, centerY + r, centerX + r, centerY + r);
        mPath.moveTo(centerX + r, centerY - r);
        mPath.cubicTo(centerX + r, centerY + r, centerX - r, centerY - r, centerX - r, centerY + r);
        canvas.drawPath(mPath, mPaint);
    }
}
