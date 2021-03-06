package com.huangshihe.salary.core.util;

/**
 * Created by dell on 2016/11/6.
 */
public enum Op {
    EQ, GE, LE, GT, LT, IN, LIN, AIN, RIN;

    //    GE:>=,LE:<=,GT:>,LT:<,IN:(),LIN:[),AIN:[],RIN:(]
    public static Op getOp(String opStr) {
        switch (opStr) {
            case "=":
                return EQ;
            case ">=":
                return GE;
            case "<=":
                return LE;
            case ">":
                return GT;
            case "<":
                return LT;
            case "()":
                return IN;
            case "[)":
                return LIN;
            case "[]":
                return AIN;
            case "(]":
                return RIN;
            default:
                return EQ;
        }
    }

    public static boolean getValue(Object vProve, Op op, Object rValue, boolean isNumber) {
        // 如果提供的值是数组
        if (DataHelper.isContentArray(vProve)) {
            return getArrayValue(vProve, op, (Object[]) rValue, isNumber);
        } else if (isNumber) {
            // 如果是数字，即就是Double
            return getSingleValue((Double) vProve, op, (Double) rValue);
        } else {
            // 如果是字符
            return vProve.equals(rValue);
        }
    }

    private static boolean getSingleValue(Double vProve, Op op, Double rValue) {
        switch (op) {
            case GE:
                return vProve >= rValue;
            case LE:
                return vProve <= rValue;
            case GT:
                return vProve > rValue;
            case LT:
                return vProve < rValue;
            default:
                return vProve.equals(rValue);
        }

    }

    public static boolean getArrayValue(Object vProve, Op op, Object[] rValue, boolean isNumber) {
        boolean result = false;

        return result;
    }
}
