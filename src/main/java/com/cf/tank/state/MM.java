package com.cf.tank.state;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-07 23:23:25
 */
public class MM {
    private String name;
    MMState state = new MMNervousState();
    public void smile() {
        state.smile();
    }
    public void cry() {
        state.cry();
    }
    public void say() {
        state.say();
    }

    public static void main(String[] args) {
        MM mm = new MM();
        mm.smile();
        mm.cry();
        mm.say();
    }
}
