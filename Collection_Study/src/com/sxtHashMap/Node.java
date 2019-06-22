package com.sxtHashMap;

/**
 * @author fly
 * @date 2019/6/21
 */
public class Node {
    int hash;
    Object key;
    Object value;
    Node next;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
