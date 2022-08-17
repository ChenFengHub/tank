package com.cf.tank.strategy.comparable;

import java.util.Arrays;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 21:21:17
 */
public class Main {
    public static void main(String[] args) {
        Teacher[] teachers = {new Teacher(20), new Teacher(40), new Teacher(30)};
        Sorter sorter = new Sorter();
        sorter.sort(teachers);
        System.out.println(Arrays.toString(teachers));

        Student[] students = {new Student(10), new Student(12), new Student(11)};
        sorter.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
