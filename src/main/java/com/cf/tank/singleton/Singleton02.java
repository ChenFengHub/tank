package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: 跟 01 一个意思
 * @author: Mr.CF
 * @create: 2022-08-16 20:20:26
 */
public class Singleton02 {
    private static final Singleton02 INSTANCE;
    static {
        INSTANCE = new Singleton02();
    }
    private Singleton02(){};
    public static Singleton02 getInstance() {
        return INSTANCE;
    }
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton02 s1 = Singleton02.getInstance();
        Singleton02 s2 = Singleton02.getInstance();
        System.out.println(s1 == s2);
    }
}
