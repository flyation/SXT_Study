package com.sxtArrayList;

/**
 *容器初始化，add()。
 * @author fly
 * @date 2019/6/19
 */
public class SxtArrayList01 {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;     //默认初始化容量

    public SxtArrayList01() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList01(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++] = obj;
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
        SxtArrayList02 al = new SxtArrayList02();
        al.add("aa");
        al.add("bb");
        al.add("cc");
        al.add("aa");
        al.add("aa");
        System.out.println(al);
    }
}
