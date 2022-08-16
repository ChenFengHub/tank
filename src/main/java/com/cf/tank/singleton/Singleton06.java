package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: 懒汉式。该方式可以认为是一种接近完美的写法（添加个 volatile，否则还存在一个指令重排序报错问题）
 * 双重检查加锁。即达到使用时才创建对象并加载到内存，并且只使用同步代码块性能损耗较小，
 * 且双重检查加锁保证多线程访问的安全性
 * @author: Mr.CF
 * @create: 2022-08-16 21:21:09
 */
public class Singleton06 {
    private static Singleton06 INSTANCE;
    private Singleton06(){}
    public static Singleton06 getInstance() {
        if(INSTANCE == null) {
            // 执行到这里，可能已经被其他线程实例化
            synchronized (Singleton06.class) {
                if(INSTANCE == null) {
                    spendTime();
                    INSTANCE = new Singleton06();
                }
            }
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
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100;i++) {
            new Thread(()->{
                // 同一个类的不同对象 hashcode 是不同的；不同类的不同对象可能 hashcode
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
    }
}
