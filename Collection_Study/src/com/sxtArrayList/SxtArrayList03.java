package com.sxtArrayList;

/**
 *增加数组扩容。
 * @author fly
 * @date 2019/6/20
 */
public class SxtArrayList03<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;     //默认初始化容量

    public SxtArrayList03() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList03(int capacity) {
        elementData = new Object[capacity];
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
        SxtArrayList03 al = new SxtArrayList03();
        for (int i=0;i<40;i++){
            al.add("gao"+i);
        }
        System.out.println(al);
    }
}
