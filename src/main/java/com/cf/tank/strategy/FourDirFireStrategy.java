package com.cf.tank.strategy;

import com.cf.tank.*;
import com.cf.tank.factory.tank.BaseTank;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 14:14:04
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGH / 2 - Bullet.HEIGH / 2;
        DirEnum[] bullets = DirEnum.values();
        for (DirEnum bullet : bullets) {
            new Bullet(bX, bY, bullet, tank.getGroup(), ((Tank)tank).getGm());
        }
        if (tank.getGroup().equals(Group.GOOD)) {
            new Thread(() -> {
                new Audio("audio/tank_fire.wav");
            });
        }
    }
}
