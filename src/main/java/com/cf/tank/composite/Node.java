package com.cf.tank.composite;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:51
 */
public abstract class Node {
    protected String name;
    public abstract void paint(int high);

    @Override
    public String toString() {
        return name;
    }
}
