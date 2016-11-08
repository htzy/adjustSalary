package com.huangshihe.salary.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 2016/11/8.
 */
public class DataHelper {
    public static <T> List<T> getList(String string, T type) {
        List<String> strings = new ArrayList<String>(
                Arrays.asList(string.replace("[", "").replace("]", "").replace(" ", "").split(",")));
        return strings.stream().map(s -> (T) s).collect(Collectors.toList());
    }

    public static boolean isStrArray(String string) {
        // TODO 判断该字符串内容为List格式的内容如：[1,2,3]
        String pattern = "\\[.*\\]";
        return string.matches(pattern);
    }

    public static boolean isContentArray(Object object) {
        if (object.getClass().isArray()) {
            return true;
        } else if (object instanceof String) {
            // 如果是字符串，则可能字符串的内容为字符串
            return isStrArray((String) object);
        }
        return false;
    }
}
