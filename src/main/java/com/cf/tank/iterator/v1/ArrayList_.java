package com.cf.tank.iterator.v1;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-29 07:07:03
 */
public class ArrayList_ {

    Object[] objects = new Object[10];
    /**
     * 指向当前容器中空的位置，或者标识目前容器中有多少个元素
     **/
    private int index = 0;

    public Object get(int i) {
        return objects[i];
    }
    public void add(Object o) {
        if(objects.length == index) {
            int newLen = objects.length << 1;
            Object[] newObjects = new Object[newLen];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index++] =o;
    }

    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for(int i = 0; i<20; i++) {
            list.add("array:" + i);
        }
        for(int i = 0; i<20; i++) {
            System.out.println(list.get(i));
        }
    }

}
