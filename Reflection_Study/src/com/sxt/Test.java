package com.sxt;

import java.lang.reflect.Method;

/**
 * @author fly
 * @date 2019/6/27
 */
public class Test {
    //用普通方法创建一个对象
    public static void tes01() {
        User u1 = new User();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            u1.getName();
        }
        long te = System.currentTimeMillis();
        System.out.println(te - ts);
    }

    public static void tes02() throws Exception {
        //用反射创建一个对象
        User u2 = new User();
        Class clazz = u2.getClass();
        Method m = clazz.getDeclaredMethod("getName",null);
        long ts = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            m.invoke(u2,null);
        }
        long te = System.currentTimeMillis();
        System.out.println(te - ts);
    }

    public static void tes03() throws Exception {
        //用反射创建一个对象,不加安全检查
        User u2 = new User();
        Class clazz = u2.getClass();
        Method m = clazz.getDeclaredMethod("getName",null);
        m.setAccessible(true);
        long ts = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            m.invoke(u2,null);
        }
        long te = System.currentTimeMillis();
        System.out.println(te - ts);
    }

    public static void main(String[] args) throws Exception {
        tes01();
        tes02();
        tes03();

    }
}