package com.cf.tank.iterator.v3;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-30 06:06:47
 */
public interface Collection_ {
    void add(Object o);
    int size();
}

class ArrayList_ implements Collection_ {
    private Object[] objects = new Object[10];
    private int index = 0;
    @Override
    public void add(Object o) {
        if(objects.length == index) {
            int newLen = objects.length << 1;
            Object[] newObjects = new Object[newLen];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index++] =o;
    }
    @Override
    public int size() {
        return size();
    }
}

class LinkedList_ implements Collection_ {

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
        tail.next = n;
        tail = n;
        size++;
    }

    public int size() {
        return size;
    }

    private class Node {
        private Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}

class CollectionMain {
    public static void main(String[] args) {
        Collection_ collection_ = new ArrayList_();
        collection_.add("1");
        collection_ =new LinkedList_();
        collection_.add("2");
    }
}


