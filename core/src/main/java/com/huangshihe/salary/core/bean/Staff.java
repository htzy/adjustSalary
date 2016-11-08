package com.huangshihe.salary.core.bean;

import java.util.Date;

/**
 * Created by dell on 2016/11/6.
 */
public class Staff {
    private String code;
    private String name;
    private Date birthday;
    private Date hireDay;
    private boolean sex;
    private int salary;
    private double rate;

    public Staff() {
    }

    public Staff(String code, String name, Date birthday, boolean sex) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
