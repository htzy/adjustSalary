package com.huangshihe.salary.service;

import com.huangshihe.salary.core.bean.Rule;
import com.huangshihe.salary.core.bean.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by dell on 2016/11/7.
 */
public class HRService {

    // 老板加工资的规则
    static String[] stands = new String[]{
            "{Staff.Sex = 0 | Staff.Age <= 25 & Staff.Salary in [1800,2500] }=0.08",
            "{Staff.Sex = 1 | Staff.Age in (35,65) & Staff.Salary in [18000,25000] }=0.02"
    };

    /**
     * 通过字符串形式的业务规则转换为Rule类
     *
     * @param stands 业务规则字符串
     * @return 业务规则类
     */
    public List<Rule> getRules(String[] stands) {
        List<Rule> list = new ArrayList<Rule>();
        for (String stand : stands) {
            list.add(new Rule(stand));
        }
        return list;
    }

    /**
     * 对所有的员工进行工资调整
     *
     * @param staffs 所有员工
     * @param rules  所有业务规则
     */
    public void adjust(List<Staff> staffs, List<Rule> rules) {
        for (Staff staff : staffs) {
            adjust(staff, rules);
        }
    }

    /**
     * 对员工进行工资调整
     *
     * @param staff 员工
     * @param rules 所有业务规则
     */
    public void adjust(Staff staff, List<Rule> rules) {
        // TreeSet提供排序
        TreeSet<Double> rateSet = new TreeSet<Double>();
        // 可能有多个涨幅
        rateSet.addAll(rules.stream().map(rule -> rule.getRate(staff)).collect(Collectors.toList()));
        // 找到最高的涨幅并将该涨幅做为员工的涨幅
        staff.setRate(rateSet.last());
    }

    /**
     * 利用基本信息注册用户
     * @param name 用户名字
     * @param birthday 用户出生日期
     * @param sex 用户性别
     * @return 注册用户
     */
    public Staff register(String name, Date birthday, boolean sex) {
        // TODO 通过用户的基本信息注册一个员工，但是还没有决定雇佣该人，所有不用设置雇佣时间
        return null;
    }

    /**
     * 雇佣注册用户为员工
     * @param staff 注册用户
     */
    public void hire(Staff staff){
        staff.setHireDay(new Date());
        // TODO 如何设置最初工资？
        staff.setSalary(0);
    }

    // TODO 如何批量注册和雇佣员工

}
