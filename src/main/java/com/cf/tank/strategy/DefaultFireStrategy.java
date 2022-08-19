package com.cf.tank.strategy;

import com.cf.tank.Audio;
import com.cf.tank.Bullet;
import com.cf.tank.Group;
import com.cf.tank.Tank;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-18 07:07:47
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGH/2 - Bullet.HEIGH/2;
        new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTf());
        if(tank.getGroup().equals(Group.GOOD)) {
            new Thread(()->{
               new Audio("audio/tank_fire.wav");
            });
        }
    }
}
