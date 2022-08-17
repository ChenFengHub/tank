package com.cf.tank.strategy.comparator;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 14:14:05
 */
public class Dog {
    public int food;
    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return food+"";
    }
}
