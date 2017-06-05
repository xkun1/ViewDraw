package com.bigdata.viewdraw.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * user:kun
 * Date:2017/5/28 or 下午4:49
 * email:hekun@gamil.com
 * Desc:
 */

@SuppressLint("AppCompatCustomView")
public class DrawTextView extends TextView {
    private Paint mPint;

    private LinearGradient mLinearGradient;
    private int mViewWidth;
    private Context context;
    private Matrix mMatrix;

    public DrawTextView(Context context) {
        super(context);
        this.context = context;

    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth==0){
            mViewWidth=getMeasuredWidth();
            if (mViewWidth>0){
                mPint=getPaint();
                mLinearGradient=new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLACK,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPint.setShader(mLinearGradient);
                mMatrix=new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mTranslate = 0;
        if (mMatrix!=null){
            mTranslate+=mViewWidth/5;
            if (mTranslate>2*mViewWidth){
                mTranslate=-mViewWidth;
            }
            mMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }
    }
}
