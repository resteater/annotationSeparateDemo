package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Loubing
 * Date 2019/12/2 16:35
 */
public class TestFunNew {

    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException {
        int i = 2;
        Method[] methods = BizNew.class.getMethods();
        Method m = null;
        for (Method method : methods) {
            TestFunAnnotation annotation = method.getAnnotation(TestFunAnnotation.class);
            if (annotation != null) {
                if(i == annotation.i()) {
                    m = method;
                }
            }
        }
        BizNew bizNew = new BizNew();
        if (m != null) {
            m.invoke(bizNew);
        }
    }

}


class BizNew {

    @TestFunAnnotation(i = 1)
    public void d1() {
        System.out.println("d1 deal biz");
    }

    @TestFunAnnotation(i = 2)
    public void d2() {
        System.out.println("d1 deal biz");
    }

    @TestFunAnnotation(i = 3)
    public void d3() {
        System.out.println("d1 deal biz");
    }

}
