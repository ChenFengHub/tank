package com.cf.tank.factory.tank;

import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.TankFrame;
import com.cf.tank.decorator.RectBulletDecorator;
import com.cf.tank.facade.GameModel;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:56
 */
public class RectFactory extends GameAbsFactory {

    @Override
    public BaseTank createTank(int x, int y, DirEnum dir, Group group) {
        return new RectTank(x, y, dir, group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirEnum dir, Group group) {
        return new RectBulletDecorator(new RectBullet(x, y, dir, group));
    }

    @Override
    public BaseExplode createExplode(int x, int y, Group group) {
        return new RectExplode(x, y);
    }
}
