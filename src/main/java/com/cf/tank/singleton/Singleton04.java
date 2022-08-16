package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: synchronized 锁带来了性能降低问题
 * @author: Mr.CF
 * @create: 2022-08-16 20:20:41
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;
    private Singleton04(){}
    public static synchronized Singleton04 getInstance() {
        if(INSTANCE == null) {
            spendTime();
            INSTANCE = new Singleton04();
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
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }

}
