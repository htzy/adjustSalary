package com.huangshihe.salary.core.bean;

import java.util.ArrayList;
import java.util.List;

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
        rate = Double.parseDouble(sts[1].trim());
        buildSubRule(sts[0]);
        subRules = new ArrayList<SubRule>();
    }

    /**
     * 解析业务规则的前半部分得到子规则<br>
     * 首先把第一个{去掉，再把所有的分隔符用;+分隔符隔开，但是要注意第一个元素可能为""空字符串，再用;分号分割
     *
     * @param st 业务规则前半部分
     */
    private void buildSubRule(String st) {
        String[] sStr = st.replace("{", "").trim().replace("&", ";&").replace("|", ";|").replace("!", ";!").split(";");
        for (String s : sStr) {
            String ss = s.trim();
            if (ss.length() > 0) {
                subRules.add(new SubRule(ss));
            }
        }
    }

    /**
     * 获得该员工的涨幅<br>
     * 如果所有业务规则对该员工不生效，则返回涨幅0，否则返回正确的涨幅
     *
     * @param staff 员工
     * @return 工资涨幅
     */
    public double getRate(Object staff) {
        return getValues(staff) ? rate : 0;
    }

    /**
     * 遍历所有的业务规则，验证是否对该员工生效，如果都不生效则返回false，否则返回true
     *
     * @param staff 员工
     * @return 是否生效
     */
    private boolean getValues(Object staff) {
        boolean result = true;
        for (SubRule subRule : subRules) {
            result &= subRule.getValue(staff);
        }
        return result;
    }
}
