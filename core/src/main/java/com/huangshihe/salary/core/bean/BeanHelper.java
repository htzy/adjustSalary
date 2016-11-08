package com.huangshihe.salary.core.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2016/11/7.
 */
public class BeanHelper {
    public static Map<String, Boolean> classMap = new HashMap<>();

    static {
        classMap.put("Staff.Sex", true);
        classMap.put("Staff.Age", true);
        classMap.put("Staff.Salary", true);
        classMap.put("Staff.Name", false);
    }
}
