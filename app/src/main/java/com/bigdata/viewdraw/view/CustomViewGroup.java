package com.bigdata.viewdraw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * user:kun
 * Date:2017/5/29 or 下午4:39
 * email:hekun@gamil.com
 * Desc:
 */

public class CustomViewGroup extends ViewGroup {

    private int mWidth;
    private int mHeight;

    private int mLastY;
    private int mStart;
    private int mEnd;

    private Scroller mScroller;

    public CustomViewGroup(Context context) {
        super(context);
        mScroller=new Scroller(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //设置ViewGroup高度
        MarginLayoutParams layoutParams = (MarginLayoutParams) getLayoutParams();
        layoutParams.height = mHeight * childCount;
        setLayoutParams(layoutParams);

        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != View.GONE) {
                childAt.layout(l, i * mHeight, r, (i + l) * mHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
               int dy= mLastY-y;
                if (getScrollY()<0){
                    dy=0;
                }
                if (getScrollY()>getHeight()-mHeight){
                    dy=0;
                }
                scrollBy(0,dy);
                mLastY=y;
                    break;
            case MotionEvent.ACTION_UP:
                mEnd=getScrollY();
                int dScrollY=mEnd-mStart;
                if (dScrollY>0){
                    if (dScrollY<mHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        mScroller.startScroll(0,getScrollY(),0,mHeight-dScrollY);
                    }
                }else {
                    if (-dScrollY<mHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        mScroller.startScroll(0,getScrollY(),0,-mHeight-dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);

        //测量子view的高度宽度
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
        }
    }
}
