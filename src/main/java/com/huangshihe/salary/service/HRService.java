package com.huangshihe.salary.service;

import com.huangshihe.salary.core.bean.Rule;
import com.huangshihe.salary.core.bean.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by dell on 2016/11/7.
 */
public class HRService {

    // 老板加工资的规则
    static String[] stands = new String[]{
            "{Staff.Sex = 0 | Staff.Age <= 25 & Staff.Salary in [1800,2500] }=0.08",
            "{Staff.Sex = 1 | Staff.Age in (35,65) & Staff.Salary in [18000,25000] }=0.02"
    };

    public List<Rule> getRules(String[] stands) {
        List<Rule> list = new ArrayList<Rule>();
        for (String stand : stands) {
//            String[] sts = stand.split("}=");


            Rule rule = new Rule(stand);
            list.add(rule);
        }
        return list;
    }

    public void adjust(List<Staff> staffs, List<Rule> rules){
        for (Staff staff : staffs) {
            adjustment(staff, rules);
        }
    }

    private void adjustment(Staff staff, List<Rule> rules) {
        // TreeSet提供排序
        TreeSet<Double> rateSet = new TreeSet<Double>();
        // 可能有多个涨幅
        for (Rule rule : rules) {
            double rate = rule.getRate(staff);
//         TODO   double rate = rule.getRate<Staff>(staff);
            rateSet.add(rate);
        }
//        rateSet.first();
        // 找到最高的涨幅
        rateSet.last();
    }
}
