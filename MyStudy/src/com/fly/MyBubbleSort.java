package com.fly;

import java.util.Arrays;

/**
 * @program: av47103781p111
 * @description: MyBubbleSort
 * @author: fly
 * @create: 2019-05-19 16:02
 **/
public class MyBubbleSort {
    public static void main(String[] args) {
        int[] array = {18,25,33,77,46,53,64,37};
        myBubbleSort(array);
    }

/**
优化：加入flag判断，一旦在内层一轮排序中没有变化，即已完成了最终排序
 */
    public static void myBubbleSort(int[] array){
        for (int i=0;i<array.length-1;i++){
            boolean flag = true;
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    flag = false;
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            if (flag){
                System.out.println("FINISHED: "+Arrays.toString(array));
                return;
            }
        }
    }
}