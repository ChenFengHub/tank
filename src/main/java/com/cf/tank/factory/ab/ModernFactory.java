package com.cf.tank.factory.ab;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 23:23:37
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Bike();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
