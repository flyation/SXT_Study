package com.sxtArrayList;

import java.util.Arrays;

/**
 *增加set()和get()。
 *增加数组边界检查。
 * @author fly
 * @date 2019/6/20
 */
public class SxtArrayList04<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;     //默认初始化容量

    public SxtArrayList04() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList04(int capacity) {
        if (capacity<0){
            throw new RuntimeException("容器容量不能为负数");
        }else if (capacity==0 || capacity==1){
            elementData = new Object[DEFAULT_CAPACITY];
        }else{
            elementData = new Object[capacity];
        }
    }

    public void add(E element){
        //什么时候扩容
        if (size == elementData.length){
            //优先级：加减大于移位运算
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }

        elementData[size++] = element;
    }

    public void set(int index,E element){
        checkRange(index);
        elementData[index] = element;
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    //检查索引是否越界 [0,size)
    public void checkRange(int index){
        if (index<0 || index>size-1){
            throw new RuntimeException("索引越界："+index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0;i<size;i++){
            sb.append(elementData[i]).append(",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();
    }

    public static void main(String[] args) {
        SxtArrayList04<String> al = new SxtArrayList04<>();
        for (int i=0;i<20;i++){
            al.add("gao"+i);
        }
        al.set(10,"fly");
        System.out.println(al);
        al.get(10);
        System.out.println(al.get(19));
    }
}
