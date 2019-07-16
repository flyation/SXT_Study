package com.sxt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Stream终止操作
 * 查找与匹配
 * @author fly
 * @date 2019/7/15
 */
public class StreamTest4 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("bb",81,9000),
                new Employee("aa",18,7000),
                new Employee("cc",18,8000),
                new Employee("bb",18,3000),
                new Employee("dd",66,4000)
        );

        boolean b1 = employees.stream().allMatch((e) -> e.getSalary()>=5000);
        boolean b2 = employees.stream().anyMatch((e) -> e.getSalary()>=5000);
        boolean b3 = employees.stream().noneMatch((e) -> e.getSalary()>=5000);
        System.out.println(b1+" "+b2+" "+b3);

        Optional op = employees.stream().sorted((e1, e2) -> {
            if (!e1.getName().equals(e2.getName())){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getSalary(),e2.getSalary());
            }
        }).findFirst();
        System.out.println(op.get());
    }
}
