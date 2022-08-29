package com.cf.tank.iterator.v4;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-30 06:06:59
 */
public interface Iterator<E> {
    /**
     * E:Element
     * T:Type
     * V:Value
     * @return
     */
    boolean hasNext();
    E next();
}
