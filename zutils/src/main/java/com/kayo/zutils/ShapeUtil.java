package com.kayo.zutils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

public class ShapeUtil {


    /**
     * 圆形
     *
     * @param color 颜色
     */
    public static Drawable getCircleShape(int color) {
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(color);
        return drawable;
    }

    /**
     * 获取自定义圆角的 shape
     *
     * @param topLeft     左上
     * @param topRight    右上
     * @param bottomLeft  左下
     * @param bottomRight 右下
     * @param color       颜色
     */
    public static Drawable getShapeShape(int topLeft, int topRight,
                                         int bottomLeft, int bottomRight, int color) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadii(new float[]{topLeft, topLeft, topRight, topRight,
                bottomLeft, bottomLeft, bottomRight, bottomRight});
        return gd;
    }

    /**
     * 生成圆角矩形
     *
     * @param radius 圆角
     * @param color  颜色
     */
    public static Drawable getRectangleShape(int radius, int color) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadius(radius);
        return gd;
    }

    /**
     * 生成带过度色圆角矩形
     *
     * @param radius      圆角
     * @param color       颜色
     * @param orientation 颜色排布方向
     * @param startColor  开始颜色
     * @param middleColor 中间颜色
     * @param endColor    结束颜色
     */
    public static Drawable getRectangleShape(int radius, int color, GradientDrawable.Orientation orientation,
                                             int startColor, int middleColor, int endColor) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadius(radius);
        gd.setColors(new int[]{startColor, middleColor, endColor});
        gd.setOrientation(orientation);
        return gd;
    }

    /**
     * 生成圆角矩形
     *
     * @param radius      圆角
     * @param strokeWidth 边线宽度
     * @param strokeColor 边线颜色
     * @param bgColor     背景颜色
     */
    public static Drawable getRectangleShape(int radius, int strokeWidth, int strokeColor, int bgColor) {
        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(bgColor);
        gd.setCornerRadius(radius);
        gd.setStroke(strokeWidth, strokeColor);
        return gd;
    }

    public static Drawable getLightRippleShape(int rippleColor, Drawable content){
        return getRippleShape(Color.parseColor("#F2F4F8"), rippleColor, content );
    }

    public static Drawable getDarkRippleShape(int rippleColor, Drawable content) {
        return getRippleShape(Color.parseColor("#88000000"), rippleColor, content );
    }

    public static Drawable getRippleShape(int hyperColor,int rippleColor, Drawable content){
        int statePressed = android.R.attr.state_pressed;
        int stateFocused = android.R.attr.state_focused;
        int[][] state = {{statePressed}, {-statePressed}, {stateFocused}, {-stateFocused}, {}};
        int color1 = hyperColor;
        int color2 = rippleColor;
        int color3 = hyperColor;
        int color4 = rippleColor;
        int color5 = hyperColor;
        int[] color = {color1, color2, color3, color4, color5};
        ColorStateList colorStateList = new ColorStateList(state, color);
        return new RippleDrawable(colorStateList, content, new ColorDrawable(Color.parseColor("#88000000")));
    }

}
