package com.huangshihe.salary.core.bean;

import com.huangshihe.salary.core.util.Lop;
import com.huangshihe.salary.core.util.Op;

/**
 * Created by dell on 2016/11/6.
 */
public class SubRule {
    // left operate左操作符
    Lop lop;
    // 规则名
    String rName;
    Op op;
    // 类型
    Class<?> rType;
    // provide value
    Object vProve;
    //标准值
    Object rValue;
    // 是否是数字
    boolean isNumber;

    //Staff.Sex = 0
    //| Staff.Age <= 25
    //& Staff.Salary in [1800,2500]
    public SubRule(String rStr) {
        // 在这里规定每个内容必须用空格隔开
        String[] rs = rStr.split(" ");
        if (rs.length < 3 || rs.length > 4) return;
        int index = 1;
        if (rs.length == 3) {
            // 当分割后长度为3，即第一个为空，默认也做为&（AND）处理
            lop = Lop.AND;
            index = 0;
        } else {
            lop = Lop.getLop(rs[0].trim());
        }
        rName = rs[index].trim();
        this.isNumber = BeanHelper.classMap.get(rName);
        op = Op.getOp(rs[index + 1].trim());
        rValue = isNumber ? Double.parseDouble(rs[index + 2].trim()) : rs[index + 2].trim();
    }

    public Object getvProve() {
        // TODO 运用反射
        try {
            Class<?> StaffClass = Class.forName("com.huangshihe.salary.core.bean.Staff");

            Object staff = StaffClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getValue(Object staff) {

        return Op.getValue(vProve, op, rValue, isNumber);
    }
}
