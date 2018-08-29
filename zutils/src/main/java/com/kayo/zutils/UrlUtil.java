package com.kayo.zutils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.kayo.zutils.StrUtil.isEmpty;
import static com.kayo.zutils.StrUtil.isNotEmpty;

/**
 * Kayo
 * 2018/8/29
 */
public class UrlUtil {

    public static Map<String, String> parser(String pathParams) {
        Map<String, String> params = new HashMap<>();
        if (StrUtil.isEmpty(pathParams)) {
            return params;
        }
        if (pathParams.contains("&")) {
            String[] split = pathParams.split("&");
            for (String keyValue : split) {
                if (keyValue.contains("=")) {
                    String[] split1 = keyValue.split("=");
                    try {
                        String value = URLDecoder.decode(split1[1], "UTF-8");
                        params.put(split1[0], value);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (pathParams.contains("=")) {
            String[] split = pathParams.split("=");
            params.put(split[0], split[1]);
        }
        return params;
    }

    public static String queryString(Map<String, String> queries) {
        if (queries == null || queries.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<String, String>> entries = queries.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (isNotEmpty(key) && isNotEmpty(value)) {
                builder.append(key).append("=").append(value).append("&");
            }
        }
        String _temp = builder.toString();
        if (_temp.endsWith("&")) {
            _temp = _temp.substring(0, _temp.length() - 1);
        }
        return _temp;
    }

    public static String decode(String str) {
        if (isEmpty(str)) {
            return "";
        }
        try {
            str = new String(str.getBytes(), "UTF-8");
            str = URLDecoder.decode(str, "UTF-8");
            return str;
        } catch (Exception localException) {
            return "";
        }

    }

    public static String encode(String str) {
        if (isEmpty(str)) {
            return "";
        }
        try {
            str = new String(str.getBytes(), "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        } catch (Exception localException) {
            return "";
        }
    }
}
