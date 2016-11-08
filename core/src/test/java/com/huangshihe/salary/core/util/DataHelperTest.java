package com.huangshihe.salary.core.util;

import junit.framework.TestCase;

/**
 * Created by dell on 2016/11/8.
 */
public class DataHelperTest extends TestCase {
    public void testIsStrArray() throws Exception {

    }

    public void testGetList() throws Exception {
        String string = "[1,2,3]";
        System.out.println(DataHelper.getList(string, Integer.class));
    }

}