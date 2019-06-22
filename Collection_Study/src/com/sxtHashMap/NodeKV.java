package com.sxtHashMap;

/**
 * @author fly
 * @date 2019/6/21
 */
public class NodeKV<K,V> {
    int hash;
    K key;
    V value;
    NodeKV<K,V> next;
}
