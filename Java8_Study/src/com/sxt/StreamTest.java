package com.sxt;

import java.util.*;
import java.util.stream.Stream;

/**
 * 创建Stream的四种方式
 * @author fly
 * @date 2019/7/14
 */
public class StreamTest {
    public static void main(String[] args) {

        //1.通过Collection系列集合提供的的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> sm1 = list.stream();

        //2.通过Arrays类中的静态方法stream()
        Employee[] employees = new Employee[10];
        Stream<Employee> sm2 = Arrays.stream(employees);

        //3.通过Stream类中的静态方法of()
        Stream<String> sm3 = Stream.of("aa","bb","cc");

        //4.无限流
        //迭代
        Stream<Integer> sm41 = Stream.iterate(0,(x)-> x+2);
        sm41.limit(100).forEach(System.out::println);

        //生成
        Stream<Double> sm42 = Stream.generate(() -> Math.random());
        sm42.limit(100).forEach(System.out::println);
    }
}
