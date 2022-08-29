package com.cf.tank.iterator.v2;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-29 07:07:03
 */
public class LinkedList_ {
    /**
     * 目前容器中有多少元素
     **/
    private int size = 0;
    Node head = null;
    Node tail = null;

    public Object get(int i) {
        Node cur = head;
        for (int j = 0; j <= i; j++) {
            if (j == i) {
                return cur.data;
            } else {
                if (cur.next == null) {
                    return null;
                } else {
                    cur = cur.next;
                }
            }
        }
        return null;
    }

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;
        if (head == null) {
            head = n;
            tail = n;
        }
        n.prev = tail;
        tail.next = n;
        tail = n;
        head.prev = tail;
        size++;
    }

    public int size() {
        return size;
    }

    private class Node {
        private Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for(int i = 0; i<20; i++) {
            list.add("linkedlist:" + i);
        }
        for(int i = 0; i<20; i++) {
            System.out.println(list.get(i));
        }
    }
}

