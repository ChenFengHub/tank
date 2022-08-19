package com.cf.tank.factory.tank;

import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.TankFrame;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:56
 */
public class RectFactory extends GameAbsFactory {

    @Override
    public BaseTank createTank(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, Group group, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }
}
