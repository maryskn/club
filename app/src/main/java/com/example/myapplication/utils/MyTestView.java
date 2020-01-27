package com.example.myapplication.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class MyTestView extends AppCompatTextView {

    private Context context;

    public MyTestView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MyTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MyTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font.ttf");
        setTypeface(typeface);

    }
}
