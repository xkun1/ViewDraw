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
 * Date:2017/6/2 or 上午10:21
 * email:hekun@gamil.com
 * Desc: 画多边形，雷达图
 */

public class DrawPolygon extends View {

    private int mColor, mPaintColor, TextPaintColor;
    private Paint mPaint, mTextPaint,mVaulePaint;
    private String[] mTitles = {"a", "b", "c", "d", "e", "f"};
    private double[] mDatas = {100, 60, 60, 60, 100, 50, 10, 20};
    private float mMaxValue;

    private int count = 6;
    private float angle = (float) (Math.PI * 2 / count);
    private float radius = 500;
    private int centerX, centerY;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    public int getmPaintColor() {
        return mPaintColor;
    }

    public void setmPaintColor(int mPaintColor) {
        this.mPaintColor = mPaintColor;
    }

    public int getTextPaintColor() {
        return TextPaintColor;
    }

    public void setTextPaintColor(int textPaintColor) {
        TextPaintColor = textPaintColor;
    }

    public String[] getmTitles() {
        return mTitles;
    }

    public void setmTitles(String[] mTitles) {
        this.mTitles = mTitles;
    }

    public double[] getmDatas() {
        return mDatas;
    }

    public void setmDatas(double[] mDatas) {
        this.mDatas = mDatas;
    }

    public float getmMaxValue() {
        return mMaxValue;
    }

    public void setmMaxValue(float mMaxValue) {
        this.mMaxValue = mMaxValue;
    }

    public DrawPolygon(Context context) {
        super(context);
        mVaulePaint=new Paint();
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mPaint = new Paint();
        mVaulePaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public DrawPolygon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTextPaint = new Paint();
        mVaulePaint=new Paint();
        mVaulePaint.setColor(Color.BLUE);
        mTextPaint.setAntiAlias(true);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w / 2;
        centerY = h / 2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolyGon(canvas);
        drawLines(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        mVaulePaint.setAlpha(255);
        mVaulePaint.setColor(Color.BLUE);
        for(int i=0;i<count;i++){
            double percent = mDatas[i]/mMaxValue;
            float x = (float) (centerX+radius*Math.cos(angle*i)*percent);
            float y = (float) (centerY+radius*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x, centerY);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            canvas.drawCircle(x,y,10,mVaulePaint);
        }
        mVaulePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, mVaulePaint);
        mVaulePaint.setAlpha(127);
        //绘制填充区域
        mVaulePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, mVaulePaint);
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//第4象限
                canvas.drawText(mTitles[i], x, y, mTextPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {//第3象限
                canvas.drawText(mTitles[i], x, y, mTextPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {//第2象限
                float dis = mTextPaint.measureText(mTitles[i]);//文本长度
                canvas.drawText(mTitles[i], x - dis, y, mTextPaint);
            } else if (angle * i >= Math.PI && angle * i < 3 * Math.PI / 2) {//第1象限
                float dis = mTextPaint.measureText(mTitles[i]);//文本长度
                canvas.drawText(mTitles[i], x - dis, y, mTextPaint);
            }
        }
    }

    private void drawLines(Canvas canvas) {
        Path mPath = new Path();
        for (int i = 0; i < count; i++) {
            mPath.reset();
            mPath.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));
            mPath.lineTo(x, y);
            canvas.drawPath(mPath, mPaint);
        }
    }

    private void drawPolyGon(Canvas canvas) {
        Path mPath = new Path();
        float r = radius / (count - 1);
        for (int i = 0; i < count; i++) {
            float curR = r * i;
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    mPath.moveTo(centerX + curR, centerY);
                } else {
                    //根据半径，计算出蜘蛛丝上每个点的坐标
                    float x = (float) (centerX + curR * Math.cos(angle * j));
                    float y = (float) (centerY + curR * Math.sin(angle * j));
                    mPath.lineTo(x, y);
                }
            }
            mPath.close();
            canvas.drawPath(mPath, mPaint);
        }
    }
}
