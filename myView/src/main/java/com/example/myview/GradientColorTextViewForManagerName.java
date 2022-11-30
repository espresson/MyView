package com.example.myview;

import android.annotation.SuppressLint;
import android.widget.TextView;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;

@SuppressLint("AppCompatCustomView")
public class GradientColorTextViewForManagerName extends TextView {
    public GradientColorTextViewForManagerName(Context context) {
        super(context);
    }

    public GradientColorTextViewForManagerName(Context context,
                                               AttributeSet attrs) {
        super(context, attrs);
    }
    public GradientColorTextViewForManagerName(Context context,
                                               AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed,
                            int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            getPaint().setShader(new LinearGradient(
                    0, 0, getWidth(), getHeight(),
                    new int[]{0xFFFFEABA, 0xFFDFBB82, 0xFFBE8B49}, new float[]{0, 0.5f, 1},
                    Shader.TileMode.CLAMP));
        }
    }
}