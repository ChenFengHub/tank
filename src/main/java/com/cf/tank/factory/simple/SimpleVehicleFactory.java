package com.cf.tank.factory.simple;

import com.cf.tank.factory.Broom;
import com.cf.tank.factory.Car;

/**
 * @program: design-pattern-tank
 * @description: 简单工厂。一个工厂里可以生产多个类型的对象
 * 可扩展性不好，代码写死
 * @author: Mr.CF
 * @create: 2022-08-18 22:22:36
 */
public class SimpleVehicleFactory {

    public Car createCar() {
        // 工厂创建的对象的前置处理。如果对象不需要前置处理，就不需要工厂
        return new Car();
    }
    public Broom createBroom() {
        return new Broom();
    }

}
