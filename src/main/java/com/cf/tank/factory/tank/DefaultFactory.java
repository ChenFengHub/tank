package com.cf.tank.factory.tank;

import com.cf.tank.*;
import com.cf.tank.facade.GameModel;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:33
 */
public class DefaultFactory extends GameAbsFactory{

    @Override
    public BaseTank createTank(int x, int y, DirEnum dir, Group group, GameModel gm) {
        return new Tank(x, y, dir, group, gm);
    }
    @Override
    public BaseBullet createBullet(int x, int y, DirEnum dir, Group group, GameModel gm) {
        return new Bullet(x, y, dir, group, gm);
    }
    @Override
    public BaseExplode createExplode(int x, int y, Group group, GameModel gm) {
        return new Explode(x, y, gm);
    }
}
