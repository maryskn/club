package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

public class MyApplication extends Application {
    private static MyApplication myApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getMyApplication() {

        return myApplication;
    }

    public Context getcontext() {
        return getMyApplication();
    }


    public Typeface getNormalTypeface() {
        Typeface typeface = Typeface.createFromAsset(getcontext().getAssets(), "font.ttf");
        return typeface;
    }
    public Typeface getNormalTypefacemedium() {
        Typeface typeface = Typeface.createFromAsset(getcontext().getAssets(), "iransans_medium.ttf");
        return typeface;
    }
    public Typeface getNormalTypefacenormal() {
        Typeface typeface = Typeface.createFromAsset(getcontext().getAssets(), "iransans_normal.ttf");
        return typeface;
    }
    public Typeface getNormalTypefacenumber() {
        Typeface typeface = Typeface.createFromAsset(getcontext().getAssets(), "iransans_number.ttf");
        return typeface;
    }

}

