package com.cf.tank.strategy.comparable;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 21:21:09
 */
public class Student implements Comparable<Student> {
    private int age;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        if (age > o.getAge()) {
            return 1;
        } else if (age < o.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "student age:" + age;
    }
}
