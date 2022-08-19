package com.cf.tank.factory.method;

import com.cf.tank.factory.Car;

/**
 * @program: design-pattern-tank
 * @description: 工厂方法。一个工厂只生产一个对象
 * @author: Mr.CF
 * @create: 2022-08-18 22:22:41
 */
public class CarFactory {
    public Car create() {
        return new Car();
    }
}
