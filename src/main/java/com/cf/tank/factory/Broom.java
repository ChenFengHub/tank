package com.cf.tank.factory;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 22:22:38
 */
public class Broom implements Moveable {
    @Override
    public void go() {
        System.out.println("broom shua shua...");
    }
}
