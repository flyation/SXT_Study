package com.sxt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda四大内置接口
 * @author fly
 * @date 2019/7/11
 */
public class LambdaTest {
    public static void main(String[] args) {
        Predicate<Employee> pre = (e) -> e.getAge()>18;
        List<Employee> employees = Arrays.asList(
                new Employee("aa",18,3000),
                new Employee("bb",81,9000),
                new Employee("cc",18,8000),
                new Employee("dd",66,4000)
        );
        for (Employee e : employees) {
            if (pre.test(e)){
                System.out.println(e);
            }
        }
    }
    /**
     * Consumer<T>消费型接口
     * void accept(T t);
     */
    public static void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    public static void t1(){
        happy(1000, System.out::println);
    }
    /**
     * Supplier<T>消费型接口
     * T get();
     */
    public static List<Integer> getNumber(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }
    public static void t2(){
        List<Integer> ll= getNumber(10,() -> (int)(Math.random()*100));
        for (Integer integer : ll) {
            System.out.println(integer);
        }
    }
    /**
     * Function<T,R>函数型接口
     * R apply(T t);
     */
    public static double cal(int num, Function<Integer,Double> fun){
        return fun.apply(num);
    }
    public static void t3(){
        double d = cal(6,(x) ->(double)x/4);
        System.out.println(d);
    }
    /**
     * Predicate<T>断言型接口
     * boolean test(T t);
     */
    public static List<String> filterStr(List<String> strings, Predicate<String> pre){
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            if (pre.test(s)){
                list.add(s);
            }
        }
        return list;
    }
    public static void t4(){
        List<String> list1 = Arrays.asList("hi","hello","java","lambda");
        List<String> list2 = filterStr(list1,(s) -> s.startsWith("h"));
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
