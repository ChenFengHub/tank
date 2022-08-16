package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: lazy-loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题（synchronized 还没有完全解决该问题,
 * 同步代码块比锁住整个方法性能略高）
 * @author: Mr.CF
 * @create: 2022-08-16 20:20:48
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;
    private Singleton05(){}
    public static Singleton05 getInstance() {
        if(INSTANCE == null) {
            // 执行到这里，可能已经被其他线程实例化
            synchronized (Singleton05.class) {
                spendTime();
                INSTANCE = new Singleton05();
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
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100;i++) {
            new Thread(()->{
                // 同一个类的不同对象 hashcode 是不同的；不同类的不同对象可能 hashcode
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}
