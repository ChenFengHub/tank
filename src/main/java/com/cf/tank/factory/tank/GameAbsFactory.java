package com.cf.tank.factory.tank;

import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.TankFrame;
import com.cf.tank.facade.GameModel;

/**
 * @program: design-pattern-tank
 * @description: 抽象父类
 * 抽象父类尽量少，这样子类实现的越少。一般只有子类一定会用到，那一个个加到父类中
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:31
 */
public abstract class GameAbsFactory {
    public abstract BaseTank createTank(int x, int y, DirEnum dir, Group group);
    public abstract BaseBullet createBullet(int x, int y, DirEnum dir, Group group);
    public abstract BaseExplode createExplode(int x, int y, Group group);
}
