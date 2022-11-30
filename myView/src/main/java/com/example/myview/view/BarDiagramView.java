package com.example.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class BarDiagramView extends View {

    static Paint p = new Paint();
    public int value;
    public int srcWide;
    public int leftMargin;
    private boolean firstFlag = true;
    private static int lower = 400;
    private static int warn = 800;
    int fullColor = Color.parseColor("#B7F800");
    int warnColor = Color.parseColor("#F8A500");
    int lowerColor = Color.parseColor("#DB0000");

    int bgColor = Color.parseColor("#00000000");


    public BarDiagramView(Context context) {
        super(context);
    }

    public BarDiagramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BarDiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void refresh(int value) {
        if (this.value != value) {
            this.value = value;
            invalidate();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();

        int color;
        if (value > warn) {
            color = fullColor;
        } else if (value > lower) {
            color = warnColor;
        } else {
            color = lowerColor;
        }

        if (layoutParams.width > layoutParams.height) {
            int width = layoutParams.width;
            int height = layoutParams.height;

            int margin = height / 6;

            int centerX = width / 2;
            int centerY = height / 2;
            p.setStrokeWidth(1f);

            p.setColor(color);
            p.setStyle(Paint.Style.STROKE);
            //p.setStyle(Style.FILL);
         //   canvas.drawRect(margin, margin, width - margin, height - margin, p);
            //canvas.drawRect(0, 0, width, height, p);
            p.setStyle(Paint.Style.FILL);
            //电池头
//            canvas.drawRect(width - margin, centerY - margin, width, centerY + margin, p);
            int totalHeight = width - margin;
            float mh = totalHeight * value / 1000.0f;
            canvas.drawRect(margin, margin , mh + margin, height - margin , p);
            canvas.save();
        } else {
            int width = layoutParams.width;
            int height = layoutParams.height;

            int margin = width / 6;

            int centerX = width / 2;
            int centerY = height / 2;
            p.setStrokeWidth(1f);
            p.setColor(color);
            p.setStyle(Paint.Style.STROKE);
            //p.setStyle(Style.FILL);

           // canvas.drawRect(margin, margin, width - margin, height - margin, p);
            //canvas.drawRect(0, 0, width, height, p);
            p.setStyle(Paint.Style.FILL);
           // canvas.drawRect(centerX - margin, 0, centerX + margin, margin, p);
            int totalHeight = height - margin;
            float mh = totalHeight * value / 1000.0f;
            canvas.drawRect(margin , height - mh - margin, width - margin , height - margin , p);
            canvas.save();
        }
    }
}