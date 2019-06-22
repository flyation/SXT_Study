package com.fly;

import java.util.Arrays;

/**
 * @program: av47103781p107
 * @description: MyArrayCopy
 * @author: fly
 * @create: 2019-05-18 18:08
 **/
public class MyArrayCopy {
    public static void main(String[] args) {
        String[] s0 = {"dong","peng","fei","nb"};
        System.out.println("origin:"+Arrays.toString(s0));
        String[] s1 = myInsertStr(s0,s0.length/2,"fly");
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(myDeleteStr(s1,s0.length/2)));
    }

    public static String[] myInsertStr(String[]s0, int index, String str){
        String[] s1 =new String[s0.length+1];
        System.arraycopy(s0, 0, s1, 0, index);
        System.arraycopy(s0, index, s1, index+1, s0.length-index);
        s1[index] = str;
        return s1;
    }

    public static String[] myDeleteStr(String[] s0, int index){
        System.arraycopy(s0,index+1,s0,index,s0.length-index-1);
        s0[s0.length-1] = null;
        return s0;
    }
}