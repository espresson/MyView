package com.example.myview;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextViewUtils extends ReplacementSpan {
    private int mSize;
    private int startColor;
    private int endColor;


    public TextViewUtils(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;

    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mSize = (int) (paint.measureText(text, start, end));

        //这段不可以去掉，字体高度没设置，可能出现draw（）方法没有被调用，如果你调用SpannableStringBuilder后append一个字符串，效果也是会出来，下面这段就不需要了
        // 原因详见https://stackoverflow.com/questions/20069537/replacementspans-draw-method-isnt-called
        Paint.FontMetricsInt metrics = paint.getFontMetricsInt();
        if (fm != null) {
            fm.top = metrics.top;
            fm.ascent = metrics.ascent;
            fm.descent = metrics.descent;
            fm.bottom = metrics.bottom;
        }

        return mSize;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        LinearGradient lg = new LinearGradient(0, 0, 0, paint.descent() - paint.ascent(),
                startColor,
                endColor,
                Shader.TileMode.REPEAT); //从上到下渐变
        paint.setShader(lg);

        canvas.drawText(text, start, end, x, y, paint);//绘制文字
    }

   public static SpannableStringBuilder getRadiusGradientSpan(String string, int startColor, int endColor) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        TextViewUtils span = new TextViewUtils(startColor, endColor);
        spannableStringBuilder.setSpan(span, 0, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;

    }
}

//public class MainActivity extends AppCompatActivity {
//
//    private TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.text2);
//        textView.setText(getRadiusGradientSpan(
//                "这个世界\n" +
//                        "\n并没有我们看上去那么简单\n" +
//                        "\n人各有命,上天注定\n" +
//                        "\n有人天生为王,有人落草为寇\n" +
//                        "\n脚下的路如果不是你自己的选择\n" +
//                        "\n那旅程的终点在哪也没人知道\n" +
//                        "\n你会走到哪,会碰到谁,都不一定\n", 0xFF000000, 0xFFFF0000));
//    }
//
//
//    public static SpannableStringBuilder getRadiusGradientSpan(String string, int startColor, int endColor) {
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
//        TextViewUtils span = new TextViewUtils(startColor, endColor);
//        spannableStringBuilder.setSpan(span, 0, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return spannableStringBuilder;
//
//    }
//}




