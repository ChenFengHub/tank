package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * @author: Mr.CF
 * @create: 2022-08-16 20:20:34
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;
    private Singleton03(){}
    public static Singleton03 getInstance() {
        if(INSTANCE == null) {
            spendTime();
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
    private static void spendTime() {
        // 模拟创建对象花费时间，更好模拟线程安全问题
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100;i++) {
            new Thread(()->{
                // 同一个类的不同对象 hashcode 是不同的；不同类的不同对象可能 hashcode
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }

}
