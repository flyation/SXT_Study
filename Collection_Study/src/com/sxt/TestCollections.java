package com.sxt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类
 * @author fly
 * @date 2019/6/21
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("fly"+i);
        }
        System.out.println(list);

        Collections.shuffle(list);              //随机排列list元素
        System.out.println(list);

        Collections.reverse(list);              //逆序排列list元素
        System.out.println(list);

        Collections.rotate(list,2);     //旋转指定长度
        System.out.println(list);

        Collections.sort(list);                 //按递增排序。自定义类：实现Comparable接口
        System.out.println(list);
        System.out.println(Collections.binarySearch(list,"fly3"));  //二分查找

    }
}
