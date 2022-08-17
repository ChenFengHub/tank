package com.cf.tank.strategy.comparator;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 14:14:04
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compareTo(Dog o1, Dog o2) {
        if (o1.food < o2.food) {
            return -1;
        } else if (o1.food > o2.food) {
            return 1;
        } else {
            return 0;
        }
    }
}
