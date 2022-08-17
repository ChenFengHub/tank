package com.cf.tank.strategy.comparator;

import java.util.Arrays;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 14:14:07
 */
public class Main {
    public static void main(String[] args) {
        Dog[] arr = {new Dog(3), new Dog(9), new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(arr, new DogComparator());
        System.out.println(Arrays.toString(arr));

        Cat[] catArr = {new Cat(10), new Cat(20), new Cat(5)};
        sorter.sort(catArr, new CatComparator());
        System.out.println(Arrays.toString(catArr));
    }
}
