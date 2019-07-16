package com.sxt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作
 * 排序
 * @author fly
 * @date 2019/7/15
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","cc","bb","ee","dd");
        List<Employee> employees = Arrays.asList(
                new Employee("bb",81,9000),
                new Employee("aa",18,7000),
                new Employee("cc",18,8000),
                new Employee("bb",18,3000),
                new Employee("dd",66,4000)
        );

        //自然排序sorted()
//        list.stream().sorted().forEach(System.out::println);

        //定制排序sorted(Comparator comp)
        employees.stream().sorted((e1,e2) -> {
            if (!e1.getName().equals(e2.getName())){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
