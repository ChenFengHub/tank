package com.cf.tank.state;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-07 23:23:26
 */
public class MMNervousState extends MMState {
    @Override
    void smile() {
        System.out.println("nervous smile");
    }

    @Override
    void cry() {
        System.out.println("nervous cry");
    }

    @Override
    void say() {
        System.out.println("nervous say");
    }
}
