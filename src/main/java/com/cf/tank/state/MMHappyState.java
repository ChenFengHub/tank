package com.cf.tank.state;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-07 23:23:27
 */
public class MMHappyState extends MMState {
    @Override
    void smile() {
        System.out.println("Happy smile");
    }

    @Override
    void cry() {
        System.out.println("Happy cry");
    }

    @Override
    void say() {
        System.out.println("Happy say");
    }
}
