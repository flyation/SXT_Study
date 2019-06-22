package com.sxtHashMap;

/**
 * 实现put(),重写toString()。
 * @author fly
 * @date 2019/6/21
 */
public class SxtHashMap02 {
    Node[] table;    //位桶数组
    int size;        //存放键值对的个数

    public SxtHashMap02() {
        table = new Node[16];
    }

    private int myHash(int v, int length){
        return v&(length-1);
    }

    public void put(Object key,Object value){
        Node newNode = new Node(key,value);
        newNode.hash = myHash(key.hashCode(),table.length);

        Node tmp = table[newNode.hash];
        Node lastNode = null;
        if (tmp == null){
            table[newNode.hash] = newNode;
        }else{
            while (tmp!= null) {
                if (tmp.key.equals(key)){
                    tmp.value = value;
                    return;
                }
                lastNode = tmp;
                tmp = tmp.next;
            }
            lastNode.next = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i=0;i<table.length;i++){
            Node tmp = table[i];
            while (tmp != null){
                sb.append(tmp.key).append("=").append(tmp.value).append(",");
                tmp = tmp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashMap02 hm = new SxtHashMap02();
        hm.put(1,"fly1");
        hm.put(3,"fly3");
        hm.put(3,"fly7");
        hm.put(53,"same");
        hm.put(69,"same");
        hm.put(85,"same");
        System.out.println(hm);
    }
}
