package com.cf.tank.factory.ab;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 23:23:45
 */
public class AbsFactoryMain {
    public static void main(String[] args) {
        AbstractFactory absFt = new MagicFactory();
        absFt.createFood();
        absFt.createVehicle();
        absFt.createWeapon();
    }
}
