package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * user:kun
 * Date:2017/6/1 or 下午3:34
 * email:hekun@gamil.com
 * Desc: ❤️形函数
 */

public class DrawHeart extends View {
    private Paint mPaint;
    private Path mPath;
    private Point startPoint;
    private Point assistPoint;
    private Point endPoint;
    private int centerX, centerY;

    public DrawHeart(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        startPoint = new Point(100, 20);
        assistPoint = new Point(200, 30);
        endPoint = new Point(500, 200);
        mPath = new Path();
    }

    public DrawHeart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        startPoint = new Point(0, 0);
        assistPoint = new Point(0, 0);
        endPoint = new Point(0, 0);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawHeart(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        // 初始化数据点和控制点的位置
        startPoint.x = centerX - 400;
        startPoint.y = centerY;
        endPoint.x = centerX + 400;
        endPoint.y = centerY;
        assistPoint.x = centerX;
        assistPoint.y = centerY - 200;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        assistPoint.x = (int) event.getX();
        assistPoint.y = (int) event.getY();
        invalidate();
        return true;

    }

    private void drawHeart(Canvas canvas) {
// 绘制数据点和控制点
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
        //画点
        canvas.drawPoint(startPoint.x, startPoint.y, mPaint);
        canvas.drawPoint(endPoint.x, endPoint.y, mPaint);
        canvas.drawPoint(assistPoint.x, assistPoint.y, mPaint);

        // 绘制辅助线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(startPoint.x, startPoint.y, assistPoint.x, assistPoint.y, mPaint);
        canvas.drawLine(endPoint.x, endPoint.y, assistPoint.x, assistPoint.y, mPaint);

        // 绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path = new Path();

        path.moveTo(startPoint.x, startPoint.y);
        path.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);

        canvas.drawPath(path, mPaint);
    }
}
