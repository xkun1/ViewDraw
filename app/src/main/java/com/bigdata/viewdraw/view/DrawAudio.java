package com.bigdata.viewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * user:kun
 * Date:2017/5/28 or 下午6:09
 * email:hekun@gamil.com
 * Desc:
 */

public class DrawAudio extends View {
    private Paint mPaint;
    private int mRectCont = 10;
    private int mRectWidth = 50;
    private int mRectHeight = 500;
    private int offset = 10;

    public DrawAudio(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double random = Math.random();
        float current = (float) ((float) mRectHeight * random);
        for (int i = 0; i < mRectCont; i++) {
            canvas.drawRect(
                    (float) (getMeasuredWidth() * 0.4 / 2 + mRectWidth * i + offset),
                    current,
                    (float) (getMeasuredWidth() * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint
            );
        }

        postInvalidateDelayed(300);
    }

    public DrawAudio(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }
}
