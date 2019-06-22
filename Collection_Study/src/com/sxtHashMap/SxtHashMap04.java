package com.sxtHashMap;

/**
 * 增加泛型。
 * @author fly
 * @date 2019/6/21
 */
public class SxtHashMap04<K,V> {
    private NodeKV<K,V>[] table;    //位桶数组
    private int size;        //存放键值对的个数

    public SxtHashMap04() {
        table = new NodeKV[16];
    }

    private int myHash(int v, int length){
        return v&(length-1);
    }

    public void put(K key,V value){
        NodeKV newNode = new NodeKV();
        newNode.key = key;
        newNode.value = value;
        newNode.hash = myHash(key.hashCode(),table.length);

        NodeKV tmp = table[newNode.hash];
        NodeKV lastNode = null;
        if (tmp == null){                   //如果table为空，则直接添加
            table[newNode.hash] = newNode;
        }else{
            while (tmp!= null) {            //遍历链表
                if (tmp.key.equals(key)){   //如果key已存在，则覆盖
                    tmp.value = value;
                    return;
                }
                lastNode = tmp;
                tmp = tmp.next;             //向后遍历
            }
            lastNode.next = newNode;        //将要插入的键值对添加到链表尾部
        }

        size++;
    }

    public V get(K key){
        int hash = myHash(key.hashCode(),table.length);
        V value = null;

        NodeKV<K,V> tmp = table[hash];
        while (tmp != null){
            if (tmp.key.equals(key)){
                value = tmp.value;
                break;
            }else {
                tmp = tmp.next;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i=0;i<table.length;i++){
            NodeKV tmp = table[i];
            while (tmp != null){
                sb.append(tmp.key).append("=").append(tmp.value).append(",");
                tmp = tmp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtHashMap04<Integer,String> hm = new SxtHashMap04<>();
        hm.put(1,"fly1");
        hm.put(3,"fly3");
        hm.put(3,"fly7");
        hm.put(53,"same");
        hm.put(69,"same");
        hm.put(85,"same");
        System.out.println(hm);
        System.out.println(hm.get(69));
    }
}
