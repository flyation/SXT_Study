package com.sxt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream终止操作
 * 归约与收集
 * @author fly
 * @date 2019/7/15
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("bb",81,9000),
                new Employee("aa",18,7000),
                new Employee("cc",18,8000),
                new Employee("bb",18,3000),
                new Employee("dd",66,4000)
        );

        Integer[] nums = new Integer[]{1,2,3,4,5};
        Stream<Integer> sm = Arrays.stream(nums);
        sm.map((x) -> x*x).forEach(System.out::println);

        Optional<Integer> op = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(op.get());

    }
}
