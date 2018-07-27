package com.kayo.zutils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Kayo
 * 2018/7/27
 * 状态栏工具类
 */
public class BarUtil {

    private static final String TAG_COLOR = "TAG_COLOR";
    private static final String TAG_ALPHA = "TAG_ALPHA";

    public static int statusHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static void statusColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
            //底部导航栏
//            window.setNavigationBarColor(color);
        }
    }

    public static void navColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //底部导航栏
            window.setNavigationBarColor(color);
        }
    }

    public static void navBarImmersive(@NonNull final Window window) {
        View decorView = window.getDecorView();
        int uiOptions = decorView.getSystemUiVisibility();
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public static boolean navBarVisibility(@NonNull final Window window) {
        boolean isNoLimits = (window.getAttributes().flags
                & WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) != 0;
        if (isNoLimits) return false;
        View decorView = window.getDecorView();
        int visibility = decorView.getSystemUiVisibility();
        return (visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0;
    }

    public static void statusVisibility(Context context, boolean show) {
        if (context instanceof Activity) {
            statusVisibility(((Activity) context).getWindow(), show);
        }
    }

    public static void statusVisibility(@NonNull Window window, boolean show) {
        if (show) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static boolean isShowing(Context context) {
        if (context instanceof Activity) {
            return isShowing(((Activity) context).getWindow());
        }
        return false;
    }

    public static boolean isShowing(@NonNull Window window) {
        int flags = window.getAttributes().flags;
        return (flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0;
    }

    public static boolean statusIsLight(@NonNull Window window) {
        View decorView = window.getDecorView();
        int flags = decorView.getSystemUiVisibility();
        return (flags & View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0;
    }

    public static void statusStyle(@NonNull final Window window, @ModeStyle int style) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = window.getDecorView();
            if (decorView != null) {
                int vis = decorView.getSystemUiVisibility();
                if (style == ModeStyle.LIGHT) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    vis = View.SYSTEM_UI_FLAG_VISIBLE;
                } else {
                    vis = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
                decorView.setSystemUiVisibility(vis);
            }
        }
    }

    @Keep
    @IntDef({ModeStyle.LIGHT, ModeStyle.DARK})
    public @interface ModeStyle {
        int LIGHT = 0;
        int DARK = 1;
    }


}
