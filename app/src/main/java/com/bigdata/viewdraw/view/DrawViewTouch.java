package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * user:kun
 * Date:2017/5/31 or 下午3:52
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawViewTouch extends View {

    private Paint mPaint;
    private Context mContext;
    int width;
    int height;
    public DrawViewTouch(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        this.mContext=context;
    }

    public DrawViewTouch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        this.mContext=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         width = getMeasuredWidth();
         height = getMeasuredHeight();
        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(width / 2 - 300, height / 2 - 400, width / 2 + 300, height / 2 + 400);
        canvas.drawRect(rectF, mPaint);

        @SuppressLint("DrawAllocation")
        float[] floats = new float[]{
                width / 2 - 300, height / 2 - 200, width / 2 + 300, height / 2 - 200,
                width / 2 - 300, height / 2 + 200, width / 2 + 300, height / 2 + 200,
                width / 2 - 300, height / 2, width / 2 + 300, height / 2
        };
        canvas.drawLines(floats, mPaint);
        mPaint.setTextSize(50);
        canvas.drawText("确定", width / 2 - 50, height / 2 + 320, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        int x = (int) event.getX();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (width/2-300<x||x<width/2+300&&y>height/2+200||y<height/2+400){
                    Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
                }
//                if (x+getLeft()<event.getRawX()){
//
//                }
                break;
        }
        return true;

    }
}
