package com.example.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class GradientColorTextView extends TextView {

    private LinearGradient linearGradient;
    private Paint mPaint;
    private int mViewWidth=0;
    private Rect mTextBound=new Rect();

    public GradientColorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mViewWidth=getMeasuredWidth();
        mPaint=getPaint();
        String mTipText=getText().toString();
        mPaint.getTextBounds(mTipText,0,mTipText.length(),mTextBound);
        linearGradient=new LinearGradient(0,0,mViewWidth,0,   new int[]{0xFF266459, 0xFF14A49F},null, Shader.TileMode.MIRROR);
        mPaint.setShader(linearGradient);
        canvas.drawText(mTipText,getMeasuredWidth()/2-mTextBound.width()/2,getMeasuredHeight()/2+mTextBound.height()/2,mPaint);

    }
}
