package com.kayo.zutils;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 */
public final class StrUtil {

    /**
     * 判断是否为空
     * @param origin
     */
    public static boolean isEmpty(CharSequence origin) {
        if (origin == null) {
            return true;
        }
        if (origin.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为空
     * @param origin
     */
    public static boolean isNotEmpty(CharSequence origin) {
        return !isEmpty(origin);
    }

    /**
     * 判断两个字符串是否一样
     * @param origin
     * @param target
     */
    public static boolean isSame(CharSequence origin, CharSequence target) {
        if (isEmpty(origin) && isEmpty(target)) {
            return true;
        }
        if (isEmpty(origin) && isNotEmpty(target)) {
            return false;
        }
        if (isNotEmpty(origin) && isEmpty(target)) {
            return false;
        }
        return origin.equals(target);
    }

    /**
     * 判断两个字符串是否不一样
     * @param origin
     * @param target
     * @return
     */
    public static boolean isNotSame(CharSequence origin, CharSequence target) {
        return !isSame(origin, target);
    }

    /**
     * 根据长度 切割字符串
     *
     * @param origin
     * @param len
     * @return
     */
    public static String[] split(String origin, int len) {
        if (isEmpty(origin)) {
            return null;
        }
        int len2 = origin.length();
        if (len2 <= len) {
            return new String[]{origin};
        } else {
            int i = len2 / len + 1;
            String[] strA = new String[i];
            int j = 0;
            int begin = 0;
            int end = 0;
            while (j < i) {
                begin = j * len;
                end = (j + 1) * len;
                if (end > len2)
                    end = len2;
                strA[j] = origin.substring(begin, end);
                // System.out.println(strA[j]+"<br/>");
                j = j + 1;
            }
            return strA;
        }
    }

    /**
     * 根据字符串  切割字符串
     * @param origin
     * @param target
     * @return
     */
    public static String[] split(String origin, String target) {
        if (isEmpty(origin)) {
            return null;
        }
        if (isEmpty(target)){
            return new String[]{origin};
        }
        String temp = replace(target,"\\" ,"" );
        if (origin.contains(temp)){
            return origin.split(target);
        }else {
            return new String[]{origin};
        }
    }

    /**
     * 验证是不是EMAIL
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        boolean retval = false;
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        retval = matcher.matches();
        return retval;
    }

    public static boolean startWith(String origin, String start) {
        if (isEmpty(origin)) {
            return false;
        }
        if (isEmpty(start)) {
            return false;
        }
        return origin.startsWith(start);
    }

    public static boolean endWith(String origin, String end) {
        if (isEmpty(origin)) {
            return false;
        }
        if (isEmpty(end)) {
            return false;
        }
        return origin.endsWith(end);
    }

    /**
     * 是否包含 字符串
     * @param origin
     * @param target
     * @return
     */
    public static boolean contains(String origin, String target) {
        if (isEmpty(origin)) {
            return false;
        }
        if (isEmpty(target)) {
            return false;
        }
        return origin.contains(target);
    }

    /**
     * 判断是否包含字符串，忽略大小写
     * @param origin
     * @param target
     * @return
     */
    public static boolean containsIgnoreCase(String origin, String target) {
        if (isEmpty(origin) || isEmpty(target)) {
            return false;
        }
        return lowerCase(origin).contains(lowerCase(target));
    }

    /**
     * 获取字符串第一个索引
     * @param origin
     * @param target
     * @return
     */
    public static int indexOf(String origin, String target) {
        if (isEmpty(origin)) {
            return -1;
        }
        if (isEmpty(target)) {
            return -1;
        }
        return origin.indexOf(target);
    }

    /**
     * 获取字符串 第index个索引，如果index超出改字符串的最后一个索引，则返回改字符串最后一个索引
     * @param origin
     * @param target
     * @param index
     * @return
     */
    public static int indexOf(String origin, String target, int index) {
        if (isEmpty(origin)) {
            return -1;
        }
        if (isEmpty(target)) {
            return -1;
        }
        int count = -1;
        int position = 0;//当前的位置
        int cursor = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (count == index) {
                break;
            }
            int temp = origin.indexOf(target, cursor);
            if (temp >= 0) {
                position = temp;
                count++;
                cursor += position + target.length();
            } else {
                break;
            }
        }
        return position;
    }

    /**
     * 获取目标字符串的最后一个索引
     * @param origin
     * @param target
     * @return
     */
    public static int lastIndexOf(String origin, String target) {
        if (isEmpty(origin)) {
            return -1;
        }
        if (isEmpty(target)) {
            return -1;
        }
        return origin.lastIndexOf(target);
    }

    public static int lastIndexOf(String origin, String target, int index) {
        if (isEmpty(origin)) {
            return -1;
        }
        if (isEmpty(target)) {
            return -1;
        }
        if (index <= 0) {
            return -1;
        }

        int position = -1;
        String temp = origin;
        for (int i = index; i > 0; i--) {
            position = lastIndexOf(temp, target);
            if (position >= 0) {
                temp = temp.substring(0, position);
            } else {
                break;
            }
        }
        return position;
    }

    /**
     * 获取字符串左边len长度的字符串并返回
     * @param origin
     * @param len
     * @return
     */
    public static String left(String origin, int len) {
        if (isEmpty(origin)) {
            return "";
        }
        if (len > origin.length()) {
            return "";
        }
        return origin.substring(0, len);
    }

    /**
     * 获取字符串右边len长度的字符串并返回
     * @param origin
     * @param len
     * @return
     */
    public static String right(String origin, int len) {
        if (isEmpty(origin)) {
            return "";
        }
        if (len > origin.length()) {
            return origin;
        }
        int start = origin.length() - len;
        return origin.substring(start);
    }

    /**
     * 重复count个origin字符串并拼接
     * @param origin
     * @param count
     * @return
     */
    public static String repeat(String origin, int count) {
        if (isEmpty(origin)) {
            return "";
        }
        if (count < 2) {
            return origin;
        }
        StringBuilder builder = new StringBuilder(origin);
        for (int i = 0; i < count - 1; i++) {
            builder.append(origin);
        }
        return builder.toString();

    }

    /**
     * 去除两端空格
     * @param origin
     * @return
     */
    public static String trim(String origin) {
        if (isEmpty(origin)) {
            return null;
        }
        return origin.trim();
    }

    /**
     * 拼接字符串
     * @param originList
     * @param space
     * @return
     */
    public static String join(List<String> originList, String space){
        if (originList == null || originList.size()==0) {
            return "";
        }
        String[] objects = (String[]) originList.toArray();
        return join(objects,space );
    }

    /**
     * 拼接字符串
     * @param originList
     * @param space
     * @return
     */
    public static String join(String[] originList,String space){
        if (originList == null || originList.length==0) {
            return "";
        }
        if (isEmpty(space)){
            space = "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originList.length; i++) {
            if (isNotEmpty(originList[i])) {
                builder.append(originList[i]);
            }
            if (i != originList.length-1 && isNotEmpty(space)){
                builder.append(space);
            }
        }
        return builder.toString();
    }

    /**
     * 拼接字符串
     */
    public static String join(String origin,String target,String space){
        if (isEmpty(origin) && isEmpty(target)) {
            return "";
        }
        if (isEmpty(space)) {
            space = "";
        }
        if (isNotEmpty(origin) && isNotEmpty(target)){
            return origin+space+target;
        }
        if (isNotEmpty(origin)) {
            return origin;
        }
        if (isNotEmpty(target)){
            return target;
        }
        return "";
    }

    public static String encode(String origin, String code) {
        try {
            return URLEncoder.encode(origin, code);
        } catch (Exception ex) {
            ex.fillInStackTrace();
            return "";
        }
    }

    public static String decode(String origin, String code) {
        try {
            return URLDecoder.decode(origin, code);
        } catch (Exception ex) {
            ex.fillInStackTrace();
            return "";
        }
    }

    /**
     * 移除开始边的 字符串
     * @param origin
     * @param target
     * @return
     */
    public static String removeStart(String origin, String target) {
        if (isEmpty(origin)) {
            return "";
        }
        if (isEmpty(target)) {
            return origin;
        }
        if (origin.length() < target.length()) {
            return origin;
        }
        if (startWith(origin, target)) {
            return origin.substring(target.length());
        }
        return origin;
    }

    /**
     * 移除结束边的 字符串
     * @param origin
     * @param target
     * @return
     */
    public static String removeEnd(String origin, String target) {
        if (isEmpty(origin)) {
            return "";
        }
        if (isEmpty(target)) {
            return origin;
        }
        if (origin.length() < target.length()) {
            return origin;
        }
        if (endWith(origin,target )){
            return left(origin,origin.length()-target.length() );
        }
        return origin;
    }

    /**
     * 获取右边size长度的字符串并返回
     * @param origin
     * @param size
     * @return
     */
    public static String rightPad(String origin, int size) {
        if (isEmpty(origin)) {
            return "";
        }
        int len = origin.length();
        if (size <= len) {
            return origin;
        }
        StringBuilder strBuilder = new StringBuilder(origin);
        for (int i = 0; i < len - size; i++) {
            strBuilder.append(" ");
        }
        origin = strBuilder.toString();
        return origin;
    }

    /**
     * 获取左边size长度的字符串并返回
     * @param origin
     * @param size
     * @return
     */
    public static String leftPad(String origin, int size) {
        if (isEmpty(origin)) {
            return "";
        }
        int len = origin.length();
        if (size <= len) {
            return origin;
        }
        StringBuilder strBuilder = new StringBuilder(origin);
        for (int i = 0; i < len - size; i++) {
            strBuilder.insert(0, " ");
        }
        origin = strBuilder.toString();
        return origin;
    }

    /**
     * 全部大写
     * @param origin
     * @return
     */
    public static String upperCase(String origin) {
        if (isNotEmpty(origin)) {
            return origin.toUpperCase();
        }
        return "";

    }

    /**
     * 全部小写
     * @param origin
     * @return
     */
    public static String lowerCase(String origin) {
        if (isNotEmpty(origin)) {
            return origin.toLowerCase();
        }
        return "";
    }

    /**
     * 删除所有以下字符：空格 \n \f \t \r
     * @param origin
     * @return
     */
    public static String deleteWhitespace(String origin){
        if (isEmpty(origin)) {
            return "";
        }
        origin = replace(origin," " ,"" );
        origin = replace(origin,"\r" ,"" );
        origin = replace(origin,"\n" ,"" );
        origin = replace(origin,"\t" ,"" );
        origin = replace(origin,"\f" ,"" );
        return origin;
    }

    /**
     * 获取origin中 包含几个target字符串
     * @param origin
     * @param target
     * @return
     */
    public static int countMatches(String origin, String target) {
        if (isEmpty(origin)) {
            return 0;
        }
        if (isEmpty(target)) {
            return 0;
        }
        if (!contains(origin, target)) {
            return 0;
        }
        int count = 0;
        int position = 0;//当前的位置
        int cursor = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int temp = origin.indexOf(target, cursor);
            if (temp >= 0) {
                position = temp;
                count++;
                cursor += position + target.length();
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * delete file
     *
     * @param fileName
     * @return -1 exception,1 success,0 false,2 there is no one directory of the
     * same name in system
     */
    public static int deleteFile(String fileName) {
        File file = null;
        int returnValue = -1;
        try {
            file = new File(fileName);
            if (file.exists())
                if (file.delete())
                    returnValue = 1;
                else
                    returnValue = 0;
            else
                returnValue = 2;

        } catch (Exception e) {
            System.out.println("Exception:e=" + e.getMessage());
        } finally {
            file = null;
            // return returnValue;
        }
        return returnValue;
    }

    /**
     * 字符串全文替换
     *
     * @param origin
     * @param oldstr
     * @param newstr
     * @return
     */
    public static String replaceAll(String origin, String oldstr, String newstr) {
        if (origin == null || origin.trim().equals(""))
            return null;
        StringBuffer sb = new StringBuffer(origin);
        int begin = 0;
        // int from = 0;
        begin = origin.indexOf(oldstr);
        while (begin > -1) {
            sb = sb.replace(begin, begin + oldstr.length(), newstr);
            origin = sb.toString();
            begin = origin.indexOf(oldstr, begin + newstr.length());
        }
        return origin;
    }

    public static String[] replaceAll(String[] obj, String oldString, String newString) {
        if (obj == null) {
            return null;
        }
        int length = obj.length;
        String[] returnStr = new String[length];
        for (int i = 0; i < length; i++) {
            returnStr[i] = replaceAll(obj[i], oldString, newString);
        }
        return returnStr;
    }

    /**
     * 字符串替换
     *
     * @param origin
     * @param oldString
     * @param newString
     * @return
     */
    public static String replace(String origin, String oldString,
                                       String newString) {
        if (origin == null) {
            return null;
        }
        int i = 0;
        if ((i = origin.indexOf(oldString, i)) >= 0) {
            char[] line2 = origin.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = origin.indexOf(oldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return origin;
    }

    /**
     * 替换字符串，忽略大小写
     * @param origin
     * @param oldString
     * @param newString
     * @return
     */
    public static String replaceIgnoreCase(String origin, String oldString,
                                                 String newString) {
        if (origin == null) {
            return null;
        }
        String lcLine = origin.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char[] line2 = origin.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return origin;
    }

}
