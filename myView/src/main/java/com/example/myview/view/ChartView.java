package com.example.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class ChartView extends BaseView {



    public ChartView(Context context) {
        super(context);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 画柱形图上的值
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawColumnValue(Canvas canvas, Paint mPaint) {
        float cellWidth = width/axisDividedSizeX;
        if (columnInfo != null){
            mPaint.setColor(Color.parseColor("#4682B4"));
            for (int i = 0; i < columnInfo.length; i++) {
                float leftTopY = originalY - height*(columnInfo[i][0])/axisDividedSizeY;
                canvas.drawText(columnInfo[i][0]+"",
                        (originalX + cellWidth*(i+1)) + cellWidth/2,
                        leftTopY - 10, mPaint);
            }

        }
    }

    /**
     * 画柱形条
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawColumn(Canvas canvas, Paint mPaint) {

        if (columnInfo != null){
            float cellWidth = width/axisDividedSizeX;
            for (int i = 0; i < columnInfo.length; i++) {
                mPaint.setColor(columnInfo[i][1]);
                float leftTopY = originalY - height*(columnInfo[i][0])/axisDividedSizeY;
                canvas.drawRect(originalX + cellWidth * (i + 1),
                        leftTopY, originalX+cellWidth*(i+2), originalY, mPaint);
            }
        }
    }

    /**
     * 画Y轴的刻度值
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawYAxisScaleValue(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setStrokeWidth(2);
        float cellHeight = height / axisDividedSizeY;
        for (int i = 0; i < axisDividedSizeY; i++) {
            canvas.drawText(String.valueOf(i),
                    originalX - 30,
                    originalY - cellHeight * i + 10, mPaint);
        }
    }

    /**
     * 画Y轴的刻度
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawYAxisScale(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setStrokeWidth(2);
        float cellHeight = height / axisDividedSizeY;
        for (int i = 0; i < axisDividedSizeY - 1; i++) {
            canvas.drawLine(originalX, (originalY - cellHeight * (i+1)),
                    originalX + 10, (originalY - cellHeight * (i+1)), mPaint);
        }
    }

    /**
     * 画X轴的刻度值
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawXAxisScaleValue(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setTextSize(16);
//        mPaint.setFakeBoldText(true);
        float cellWidth = width/axisDividedSizeX;
        for (int i = 0; i < axisDividedSizeX; i++) {
            canvas.drawText(String.valueOf(i), cellWidth * (i+1) + originalX - 35,
                    originalY + 30, mPaint);
        }

    }

    /**
     * 画X轴刻度
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawXAxisScale(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setStrokeWidth(2);
        float cellWidh = width / axisDividedSizeX;
        for (int i = 0; i < axisDividedSizeX - 1; i++) {
            canvas.drawLine(cellWidh * (i+1) + originalX,
                    originalY,
                    cellWidh * (i+1) + originalX,
                    originalY- 10, mPaint );
        }
    }

    /**
     * 画Y轴
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawYAxis(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setStrokeWidth(3);
        canvas.drawLine(originalX, originalY, originalX, originalY- height, mPaint);

    }

    /**
     * 画X轴
     * @param canvas
     * @param mPaint
     */
    @Override
    protected void drawXAxis(Canvas canvas, Paint mPaint) {

        mPaint.setColor(mAxisTextColor);
        mPaint.setStrokeWidth(3);
        canvas.drawLine(originalX, originalY, originalX + width, originalY, mPaint);
    }
}

