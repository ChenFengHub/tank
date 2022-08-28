package com.cf.tank.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-29 06:06:22
 */
public class CglibDynamicProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        // Interceptor 类似 JDK 反射中的 InvocationHandler
        enhancer.setCallback(new LogInterceptor());
        Tank tankExtend = (Tank)enhancer.create();
        tankExtend.move();
    }
}
class LogInterceptor implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // obj 就是代理对象；method 就是要执行的方法，采用反射；args 方法的参数；proxy 是方法代理，我们这里就是执行这个
        System.out.println("代理父类："+obj.getClass().getSuperclass().getName());
        System.out.println("类本身："+obj.getClass().getName());
        System.out.println("before deal...");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("after deal..." + result);
        return result;
    }
}