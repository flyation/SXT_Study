package com.sxtLinkedList;

/**
 * 增加get()和rangeCheck()。
 * @author fly
 * @date 2019/6/21
 */
public class SxtLinkedList02 {
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

    public Object get(int index){
        rangeCheck(index);

        Node tmp;
        if (index <= (size>>1)){
            tmp = first;
            for (int i=0;i<index;i++){
                tmp =tmp.next;
            }
        }else{
           tmp = last;
           for (int i=size-1;i>index;i--){
               tmp =tmp.previous;
           }
        }
        return tmp.element;
    }

    //索引检查
    private void rangeCheck(int index){
        if (index < 0 || index > size-1){
            throw new RuntimeException("索引越界："+index);
        }
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
        SxtLinkedList02 ll = new SxtLinkedList02();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("x");
        ll.add("y");
        ll.add("z");

        System.out.println(ll);
        System.out.println(ll.size);
        System.out.println(ll.get(1));
        System.out.println(ll.get(5));
    }
}
