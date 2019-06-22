package com.sxtLinkedList;

/**
 * 自定义一个链表,add()。
 * @author fly
 * @date 2019/6/21
 */
public class SxtLinkedList01 {
    private Node first;
    private Node last;
    private int size;

    public void add(Object element){
        Node node = new Node(element);
        if (first==null){
            first = node;
            last = node;
        }else{              //a,b,c
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node tmp = first;
        while (tmp != null){
            sb.append(tmp.element).append(",");
            tmp = tmp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtLinkedList01 ll = new SxtLinkedList01();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("x");
        ll.add("y");

        System.out.println(ll);
    }
}
