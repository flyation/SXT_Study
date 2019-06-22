package com.sxtHashSet;

import com.sxtHashMap.SxtHashMap01;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 手动实现一个hashSet
 * @author fly
 * @date 2019/6/21
 */
public class SxtHashSet<E> {
    HashMap<E,Object> map;
    static final Object PRESENT= new Object();

    public SxtHashSet() {
        map = new HashMap<>();
    }

    public void add(E element){
        map.put(element,PRESENT);
    }

    public void remove(E elment){
        map.remove(elment);
    }

    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object obj:map.keySet()){
            sb.append(obj).append(",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }


    public static void main(String[] args) {
        SxtHashSet<Integer> hs = new SxtHashSet();
        hs.add(5);
        hs.add(3);
        hs.add(5);
        hs.add(7);

        System.out.println(hs);
        hs.remove(5);
        System.out.println(hs);
    }
}
