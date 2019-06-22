package com.fly;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: av47103781p 112
 * @description: MyBinarySearch
 * @author: fly
 * @create: 2019-05-19 17:28
 **/
public class MyBinarySearch {
    public static void main(String[] args) {
        int[] array = {18,25,33,77,46,53,64,37};
        Arrays.sort(array);
        System.out.println("ARRAY: "+Arrays.toString(array));
        System.out.println("plz input a value to search in ARRAY:");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println("the index is "+myBinarySearch(array,value));
    }

    public static int myBinarySearch(int[] array, int value){
        int low = 0;
        int high=array.length-1;
        if (value<array[low]||value>array[array.length-1]){
            return -1;
        }
        //首位要相交，否则极端情况下（被查找值在两侧）时不会被查到
        while (low<=high){
            int mid = (low+high)/2;
            if (value==array[mid]){
                return mid;
            }else if (value<array[mid]){
                high = mid - 1;
            }else if (value>array[mid]){
                low = mid + 1;
            }
        }
        return -1;
    }
}