package com.cf.tank.ASM;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-30 21:21:43
 */
public class TimeProxy {
    public static void before() {
        TimeProxy.before();
        System.out.println("前置方法");
    }
}
