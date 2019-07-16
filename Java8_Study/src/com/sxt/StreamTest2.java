package com.sxt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作
 * 映射
 * @author fly
 * @date 2019/7/14
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        //map(类比List的add())
        Stream<Stream<Character>> sm1 = list.stream().map(StreamTest2::transform);
        sm1.forEach((sm) -> sm.forEach(System.out::println));
        //flatMap(类比List的addAll())
        Stream<Character> sm2 = list.stream().flatMap(StreamTest2::transform);
        sm2.forEach(System.out::println);
    }


    public static Stream<Character> transform(String str){
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
                list.add(c);
        }
        return list.stream();
    }
}
