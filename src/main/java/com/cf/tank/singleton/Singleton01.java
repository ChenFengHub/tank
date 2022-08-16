package com.cf.tank.singleton;

/**
 * @program: design-pattern-tank
 * @description: 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM 保证线程安全
 * 优点：简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * @author: Mr.CF
 * @create: 2022-08-16 13:13:12
 */
public class Singleton01 {
    /** 线程安全的。JVM 保证一个类只会被加载到内存一次，保证这里只会被实例化一次 **/
    private static final Singleton01 INSTANCE = new Singleton01();
    private Singleton01(){};
    public static Singleton01 getInstance() {
        return INSTANCE;
    }
    public void m() {
        System.out.println("m");
    }


    public static void main(String[] args) {
        Singleton01 s1 = Singleton01.getInstance();
        Singleton01 s2 = Singleton01.getInstance();
        System.out.println(s1 == s2);
    }

}
