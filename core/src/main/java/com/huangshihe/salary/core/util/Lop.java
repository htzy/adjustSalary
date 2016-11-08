package com.huangshihe.salary.core.util;

/**
 * Created by dell on 2016/11/6.
 */
public enum Lop {
    AND, OR, NOT;

    public static Lop getLop(String lopStr) {
        switch (lopStr) {
            case "|":
                return OR;
            case "&":
                return AND;
            case "!":
                return NOT;
            default:
                return AND;
        }
    }
}
