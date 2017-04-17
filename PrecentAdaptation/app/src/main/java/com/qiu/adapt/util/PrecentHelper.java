package com.qiu.adapt.util;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by qiu on 16/11/22.
 */

public final class PrecentHelper {
    private PrecentHelper() {

    }

    private static PrecentHelper instance = null;

    private int designWidth = 0;

    private int designHeight = 0;

    private float designDensity = 1;

    private int screenWidth = 0;

    private int screenHeight = 0;

    private float density = 0;

    private boolean isInited = false;

    private static final String META_DESIGN_WIDTH = "design_width";
    private static final String META_DESIGN_HEIGHT = "design_height";

    public static PrecentHelper i() {
        if (instance == null) {
            instance = new PrecentHelper();
        }
        return instance;
    }

    public void init(Activity context) {
        if (context == null || isInited) {
            return;
        }

        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                designWidth = (int) applicationInfo.metaData.get(META_DESIGN_WIDTH);
                designHeight = (int) applicationInfo.metaData.get(META_DESIGN_HEIGHT);
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e("qiuzhiyuan", "name not found exception");
        }

        WindowManager windowManager = context.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metric = new DisplayMetrics();
        display.getMetrics(metric);
        screenWidth = metric.widthPixels;
        screenHeight = metric.heightPixels;
        density = metric.density;

        isInited = true;
        Log.d("qiuzhiyuan", "designWidth:" + designWidth + " designHeight:" + designHeight
                + " screenWidth:" + screenWidth + " screenHeight:" + screenHeight + " density:" + density);
    }

    public int getDesignWidth() {
        return designWidth;
    }

    public int getDesignHeight() {
        return designHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public float getDensity() {
        return density;
    }

    public float getDesignDensity() {
        return designDensity;
    }

    public int getPrecentByWidth(int width) {
        if (getDesignWidth() > 0 && getScreenWidth() > 0) {
            return (int) (width / (float) getDesignWidth() * getScreenWidth());
        }
        return width;
    }

    public int getPrecentByHeight(int height) {
        if (getDesignHeight() > 0 && getScreenHeight() > 0) {
            return (int) (height / (float) getDesignHeight() * getScreenHeight());
        }

        return height;
    }

    public static void recycle() {
        instance = null;
    }
}