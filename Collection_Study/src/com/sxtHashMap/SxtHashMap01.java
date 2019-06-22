package com.sxtHashMap;

/**
 * 自定义一个hashMap。
 * @author fly
 * @date 2019/6/21
 */
public class SxtHashMap01 {
    Node[] table;    //位桶数组
    int size;        //存放键值对的个数

    public SxtHashMap01() {
        table = new Node[16];
    }

    private int myHash(int v, int length){
        System.out.println("myHash is: "+(v&(length-1)));
        return v&(length-1);
    }

    public void put(Object key,Object value){
        Node newNode = new Node(key,value);
        newNode.hash = myHash(key.hashCode(),table.length);

        Node tmp = table[newNode.hash];
        if (tmp == null){
            table[newNode.hash] = newNode;
        }else{

        }
    }

    public static void main(String[] args) {
        SxtHashMap01 hm = new SxtHashMap01();
        hm.put(1,"fly1");
        hm.put(3,"fly3");
        hm.put(7,"fly7");
        System.out.println(hm);
    }
}
