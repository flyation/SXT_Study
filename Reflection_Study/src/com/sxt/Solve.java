package com.sxt;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author fly
 * @date 2019/6/27
 */
public class Solve {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.sxt.User");
            //获得类的所有有效注解
            Annotation[] annos = clazz.getAnnotations();
            for (Annotation anno : annos) {
                System.out.println(anno);
            }
            //获得类的指定注解
            SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(st);

            //获得属性的注解
            Field f = clazz.getDeclaredField("name");
            SxtField sxtField = f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName()+"  "
                    +sxtField.length()+"  "+sxtField.type());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
