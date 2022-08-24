package com.cf.tank.facade;

import com.cf.tank.mediator.GameObject;
import com.cf.tank.factory.tank.BaseBullet;
import com.cf.tank.factory.tank.BaseTank;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 08:08:18
 */
public class TankBulletCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
             return !((BaseBullet) o1).collideWith((BaseTank) o2);
        } else if(o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        } else {
            return true;
        }
    }
}
