package com.cf.tank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 20:20:10
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");     // 老版本 JDK 用此，将代理字节码类输出
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");   // 新版本 JDK 用此，将代理字节码类输出
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogProxy(new Tank())
        );
        m.move();
    }
}

class LogProxy implements InvocationHandler {
    Tank tank;
    public LogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("log begin ...");
        tank.move();
        System.out.println("log end ...");
        return null;
    }
}

