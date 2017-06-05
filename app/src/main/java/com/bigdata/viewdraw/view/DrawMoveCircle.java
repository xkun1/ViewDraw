package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * user:kun
 * Date:2017/5/31 or 下午5:33
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawMoveCircle extends View {
    private Paint mPaint;
    private PointF currrentPosition = new PointF(100,100);
    //手指触摸起点坐标
    private PointF moveStartPosition = new PointF(0,0);
    //当前手指位置坐标
    private PointF moveEndPosition = new PointF(0,0);
    public DrawMoveCircle(Context context) {
        super(context);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
    }

    public DrawMoveCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(currrentPosition.x + (moveEndPosition.x - moveStartPosition.x),currrentPosition.y+(moveEndPosition.y - moveStartPosition.y),50,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                moveStartPosition.x=event.getX();
                moveStartPosition.y=event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveEndPosition.x=getX();
                moveEndPosition.y=getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                currrentPosition.x += (moveEndPosition.x - moveStartPosition.x);
                currrentPosition.y += (moveEndPosition.y - moveStartPosition.y);
                moveStartPosition.x = moveEndPosition.x;
                moveStartPosition.y = moveEndPosition.y;
                invalidate();
                break;
        }
        return true;
    }
}
