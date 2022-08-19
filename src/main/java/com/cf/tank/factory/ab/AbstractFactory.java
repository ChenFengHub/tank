package com.cf.tank.factory.ab;

/**
 * @program: design-pattern-tank
 * @description: 抽象工厂。通过多个抽象类，提供创建产品族的能力
 * @author: Mr.CF
 * @create: 2022-08-18 23:23:22
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
