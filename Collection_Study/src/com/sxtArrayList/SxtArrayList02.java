package com.sxtArrayList;

/**
 *增加泛型。
 * @author fly
 * @date 2019/6/19
 */
public class SxtArrayList02<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;     //默认初始化容量

    public SxtArrayList02() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList02(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E element){
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
        SxtArrayList02 al = new SxtArrayList02();
        al.add("aa");
        al.add("bb");
        al.add("cc");
        al.add("aa");
        al.add("aa");
        System.out.println(al);
    }
}
