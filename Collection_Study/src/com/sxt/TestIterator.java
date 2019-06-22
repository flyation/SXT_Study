package com.sxt;

import java.util.*;

/**
 * @author fly
 * @date 2019/6/21
 */
public class TestIterator {
    public static void main(String[] args) {
        testIteratorMap();
//        testIteratorList();
//        testIteratorSet();
//        testIteratorMap2();

    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bac");
        list.add("acb");


        for (Iterator<String> iter = list.iterator();iter.hasNext();){
            String tmp = iter.next();
            System.out.println(tmp);
//            iter.remove();
        }

        System.out.println("*****************************");

        for (String s:list){
            System.out.println(s);
        }
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("bb");
        set.add("aa");
        set.add("cc");

        for (Iterator<String> iter = set.iterator();iter.hasNext();){
            String tmp = iter.next();
            System.out.println(tmp);
//            iter.remove();
        }
    }

    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"bb");
        map.put(3,"aa");
        map.put(2,"cc");

        Set<Map.Entry<Integer,String>> ms = map.entrySet();

        for (Iterator<Map.Entry<Integer,String>> iter = ms.iterator(); iter.hasNext(); ) {
            Map.Entry<Integer,String> tmp = iter.next();
            System.out.println(tmp);
//            iter.remove();
//            tmp.setValue("fly");
        }

        System.out.println("********************************");

        for (Map.Entry tmp:ms){
            System.out.println(tmp);
        }
    }

    public static void testIteratorMap2(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"bb");
        map.put(3,"aa");
        map.put(2,"cc");

        Set<Integer> ks = map.keySet();

        for (Iterator<Integer> iter = ks.iterator();iter.hasNext();){
            Integer tmp = iter.next();
            System.out.println(tmp+"="+map.get(tmp));
        }

        System.out.println("********************************");

        for (int i:ks){
            System.out.println(i);
        }
    }
}
