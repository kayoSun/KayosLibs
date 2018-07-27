package com.kayo.zutils;

import java.text.DecimalFormat;
import java.util.Arrays;

public final class NumUtil {

    public static int toInt(String s) {
        return toInt(s, 0);
    }

    public static int toInt(String s, int defaultValue) {
        int temp = defaultValue;
        if (StrUtil.isEmpty(s)) {
            return temp;
        }
        try {
            temp = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static long toLong(String s) {
        return toLong(s, 0);
    }

    public static long toLong(String s, long defaultValue) {
        long temp = defaultValue;
        if (StrUtil.isEmpty(s)) {
            return temp;
        }
        try {
            temp = Long.parseLong(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static float toFloat(String s) {
        return toFloat(s, 0f);
    }

    public static float toFloat(String s, float defaultValue) {
        float temp = defaultValue;
        if (StrUtil.isEmpty(s)) {
            return temp;
        }
        try {
            temp = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static double toDouble(String s) {
        return toDouble(s, 0f);
    }

    public static double toDouble(String s, double defaultValue) {
        double temp = defaultValue;
        if (StrUtil.isEmpty(s)) {
            return temp;
        }
        try {
            temp = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static int max(int... any) {
        if (any == null) {
            return 0;
        }
        int temp = 0;
        for (int i : any) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static long max(long... any) {
        if (any == null) {
            return 0;
        }
        long temp = 0;
        for (long i : any) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static float max(float... any) {
        if (any == null) {
            return 0;
        }
        float temp = 0;
        for (float i : any) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static double max(double... any) {
        if (any == null) {
            return 0;
        }
        double temp = 0;
        for (double i : any) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static int min(int... any) {
        if (any == null) {
            return 0;
        }
        int temp = 0;
        for (int i : any) {
            if (i < temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static long min(long... any) {
        if (any == null) {
            return 0;
        }
        long temp = 0;
        for (long i : any) {
            if (i < temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static float min(float... any) {
        if (any == null) {
            return 0;
        }
        float temp = 0;
        for (float i : any) {
            if (i < temp) {
                temp = i;
            }
        }
        return temp;
    }

    public static double min(double... any) {
        if (any == null) {
            return 0;
        }
        double temp = 0;
        for (double i : any) {
            if (i < temp) {
                temp = i;
            }
        }
        return temp;
    }

    /**
     * 升序
     * @return
     */
    public static int[] sort(int... array){
        if (array == null) {
            return null;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 降序
     * @param array
     * @return
     */
    public static int[] sortDesc(int... array){
        if (array == null) {
            return null;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 升序
     * @return
     */
    public static double[] sort(double... array){
        if (array == null) {
            return null;
        }
        double temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 降序
     * @param array
     * @return
     */
    public static double[] sortDesc(double... array){
        if (array == null) {
            return null;
        }
        double temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 格式化 数字
     *
     * @param s
     * @param limit 小数位限制
     * @return
     */
    public static float formatFloat(String s, int limit) {
        float v = toFloat(s);
        if (limit < 1) {
            return (int) v;
        }
        StringBuilder builder = new StringBuilder("#.");
        for (int i = 0; i < limit; i++) {
            builder.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(builder.toString());
        return toFloat(decimalFormat.format(v));
    }

    /**
     * 格式化数字
     *
     * @param s
     * @param limit 小数位限制
     * @return
     */
    public static double formatDouble(String s, int limit) {
        double v = toDouble(s);
        if (limit < 1) {
            return (int) v;
        }
        StringBuilder builder = new StringBuilder("#.");
        for (int i = 0; i < limit; i++) {
            builder.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(builder.toString());
        return toDouble(decimalFormat.format(v));
    }

    public static boolean isDigits(String str) {
        if (StrUtil.isEmpty(str)) {
            return false;
        }
        if (StrUtil.countMatches(str, ".") > 1) {
            return false;
        }
        str = StrUtil.deleteWhitespace(str);
        if (StrUtil.contains(str, ".")) {
            String[] split = StrUtil.split(str, "\\.");
            if (split != null) {
                boolean left = isDigits(split[0]);
                boolean right = isDigits(split[1]);
                return left && right;
            } else {
                return false;
            }
        } else {
            final int len = str.length();
            for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
                cp = Character.codePointAt(str, i);
                if (!Character.isDigit(cp)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 求两个数的最大公约数
     */
    public static int commonDivisor(int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }

    /**
     * 求两数的最小公倍数
     */
    public static int commonMultiple(int m, int n) {
        return m * n / commonDivisor(m, n);
    }

}
