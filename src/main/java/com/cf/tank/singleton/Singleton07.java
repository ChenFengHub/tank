package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: 完美写法之一：懒加载方式-静态内部类方式
 * JVM 保证一个类只会被加载一次，且加载外部类时是不会加载内部类的
 * 内部类在使用前是不会加载的，实现懒加载方式且不会有多线程安全问题
 * @author: Mr.CF
 * @create: 2022-08-16 21:21:19
 */
public class Singleton07 {
    private Singleton07(){}
    private static class Singleton07Holder {
        private final static Singleton07 INSTANCE = new Singleton07();
    }
    public static Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        for(int i=0; i<100;i++) {
            new Thread(()->{
                // 同一个类的不同对象 hashcode 是不同的；不同类的不同对象可能 hashcode
                System.out.println(Singleton07.getInstance().hashCode());
            }).start();
        }
    }
}
