package com.cf.tank.factory.tank;

import com.cf.tank.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:33
 */
public class DefaultFactory extends GameAbsFactory{

    @Override
    public BaseTank createTank(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }
    @Override
    public BaseBullet createBullet(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }
    @Override
    public BaseExplode createExplode(int x, int y, Group group, TankFrame tf) {
        return new Explode(x, y, tf);
    }
}
