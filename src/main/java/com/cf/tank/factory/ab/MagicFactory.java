package com.cf.tank.factory.ab;


/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 23:23:40
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MashRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicWand();
    }
}
