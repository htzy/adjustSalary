package com.huangshihe.salary.core.util;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2016/11/7.
 */
public class OpTest extends TestCase {
    public void testGetValue() throws Exception {

        String[] arr = new String[]{"1", "2"};

        assertEquals(true, arr.getClass().isArray());
        System.out.println(Arrays.toString(arr));
        Object o = "[1, 2]";
//        System.out.println("Array.getInt(o,1) = " + Array.getInt(o, 1));
        String string = "1";

        List<String> list = new ArrayList<String>(Arrays.asList(string.replace("[", "").replace("]", "").replace(" ", "").split(",")));
        System.out.println(list.toString());
//        assertEquals(true, s.getClass().isArray());

//        assertEquals("[1, 2]", );
//        assertEquals(true, .getClass().isArray());
    }

}