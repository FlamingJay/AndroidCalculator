package com.example.calculator.controler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 设计一个自定义textView，用于显示当前正在操作的数
 */
public class MainNumTextView extends AppCompatTextView {

    Paint paint = new Paint();

    public MainNumTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);

        canvas.drawLine(0, 0, this.getWidth(), 0, paint);
        canvas.drawLine(0, this.getHeight()-1, this.getWidth(), this.getHeight()-1, paint);
        canvas.drawLine(0, 0, 0, this.getHeight()-1, paint);
        canvas.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight(), paint);
    }
}
