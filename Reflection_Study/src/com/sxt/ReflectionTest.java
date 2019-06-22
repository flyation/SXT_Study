package com.sxt;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;
import com.sxt.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author fly
 * @date 2019/5/30
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        String path = "com.sxt.User";
        Class<User> clazz = (Class<User>) Class.forName(path);

        //调用无参构造器，创建对象
        User u1 = clazz.newInstance();
        System.out.println(u1.getId()+" "+u1.getAge()+" "+u1.getName());

        //通过反射API调用构造器，创建对象
        Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
        User u2 = c.newInstance(2,21,"fly");
        System.out.println(u2.getId()+" "+u2.getAge()+" "+u2.getName());

        //通过反射API调用普通方法
        User u3 = clazz.newInstance();
        Method m = clazz.getDeclaredMethod("setAge", int.class);
        m.invoke(u3,18);
        System.out.println(u3.getAge());

        //通过反射API操作属性
        User u4 = clazz.newInstance();
        Field f = clazz.getDeclaredField("name");
        //不做安全检查
        f.setAccessible(true);
        f.set(u4,"cxk");
        System.out.println(f.get(u4));
    }
}
