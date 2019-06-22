package com.sxtLinkedList;

/**
 * 增加泛型。
 * @author fly
 * @date 2019/6/21
 */
public class SxtLinkedList05<E> {
    private Node first;
    private Node last;
    private int size;

    public void add(E element){
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

    public Node getNode(int index){
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
        return tmp;
    }

    public E get(int index){
        return (E)getNode(index).element;
    }

    public void remove(int index){
        Node tmp = getNode(index);

        if (tmp == first){
            first = tmp.next;
        }else if (tmp ==last){
            last = tmp.previous;
        }else{
            Node up = tmp.previous;
            Node down = tmp.next;
            up.next = down;
            down.previous = up;
        }
        size--;
    }

    public void insert(int index,E element){
        Node newNode = new Node(element);

        if (index == 0){
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }else if (index == size-1){
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        }else {
            Node up = getNode(index-1);
            Node down = getNode(index);
            up.next = newNode;
            newNode.next = down;
            down.previous = newNode;
            newNode.previous = up;
        }
        size++;
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
        SxtLinkedList05<String> ll = new SxtLinkedList05<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("x");
        ll.add("y");
        ll.add("z");

        System.out.println(ll);
        System.out.println(ll.size);
        ll.insert(0,"m");
        ll.insert(ll.size-1,"n");
        ll.insert(2,"fly");
        System.out.println(ll);
        System.out.println(ll.size);
    }
}
