package com.sxtLinkedList;

/**
 * @author fly
 * @date 2019/6/21
 */
public class Node {
    Object element;     //元素数据
    Node previous;              //上一节点
    Node next;                  //下一节点

    public Node(Object element) {
        this.element = element;
    }

    public Node(Object element, Node previous, Node next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }
}
