package com.cf.tank.strategy.comparator;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 07:07:49
 */
public interface Comparator<T> {
    int compareTo(T attr1, T attr2);
}
