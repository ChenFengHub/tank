package com.cf.tank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
