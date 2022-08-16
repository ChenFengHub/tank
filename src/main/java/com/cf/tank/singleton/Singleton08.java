package com.cf.tank.singleton;

import java.util.Random;

/**
 * @program: design-pattern-tank
 * @description: 完美实现方式2：枚举。不仅可以解决多线程安全问题，还可以防止反序列化。
 * @author: Mr.CF
 * @create: 2022-08-16 21:21:28
 */
public enum  Singleton08 {
    INSTANCE;
    private int age = 10;
    public void setAge(int age) {
        this.age = age;
    }
    public void m() {
        System.out.println("m" + age);
    }

    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0; i<100;i++) {
            new Thread(()->{
                // 同一个类的不同对象 hashcode 是不同的；不同类的不同对象可能 hashcode
                System.out.println(Singleton08.INSTANCE.hashCode());
                if(random.nextInt(10) > 7) {
                    Singleton08.INSTANCE.setAge(100);
                }
                Singleton08.INSTANCE.m();
            }).start();
        }
    }
}
