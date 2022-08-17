package com.cf.tank.strategy.comparator;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 14:14:12
 */
public class Cat {
    public int weight;
    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "" + weight;
    }
}
