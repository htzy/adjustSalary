package com.huangshihe.salary.core.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/11/6.
 */
public class Rule {
    private List<SubRule> subRules;
    private double rate;

    /**
     * 根据业务规则字符串创建业务规则对象
     *
     * @param stand 业务规则字符串
     */
    public Rule(String stand) {
        String[] sts = stand.split("}=");
      /*  Double r = Double.valueOf(sts[1]);
      TODO valueOf 和parseDouble的区别：valueOf为对象，而parseDouble返回值
       高性能的程序使用double值，而框架希望使用Double对象，因为对象可以暂时不赋值，为null*/
        rate = Double.parseDouble(sts[1].trim());
//        sts[0].substring(1, sts[0].length())
        // 首先把第一个{去掉，再把所有的分隔符用;+分隔符隔开，但是要注意第一个元素可能为""空字符串，再用;分号分割
        buildSubRule(sts[0]);
    }

    private void buildSubRule(String st) {
        String[] sStr = st.replace("{", "").trim().replace("&", ";&").replace("|", ";|").replace("!", ";!").split(";");
        for (String s : sStr) {
            String ss = s.trim();
            if (ss.length() > 0) {
                subRules.add(new SubRule(ss));
            }
        }
    }

    // 因为java泛型不彻底，所以可以直接用Object
//    public double getRate<T>(T t) {
//
//    }
    public double getRate(Object staff) {
        return getValues(staff) ? rate : 0;
    }

    private boolean getValues(Object staff) {
        boolean result = true;
        for (SubRule subRule : subRules) {
            result &= subRule.getValue(staff);
        }
        return false;
    }
}
