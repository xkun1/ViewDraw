package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * user:kun
 * Date:2017/5/29 or 下午5:15
 * email:hekun@gamil.com
 * Desc:
 */

public class ViewGroupB extends ViewGroup {
    public static final String TAG = ViewGroupB.class.getSimpleName();

    private Paint mPint;

    public ViewGroupB(Context context) {
        super(context);
        mPint = new Paint();
    }

    public ViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPint = new Paint();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, 200, mPint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }
}
