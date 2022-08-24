package com.cf.tank.facade;

import com.cf.tank.Wall;
import com.cf.tank.factory.tank.BaseTank;
import com.cf.tank.factory.tank.BaseWall;
import com.cf.tank.mediator.GameObject;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 21:21:53
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseWall && o2 instanceof BaseTank) {
            if (((BaseWall) o1).collideWith((BaseTank) o2)) {
                ((BaseTank) o2).retreat();
            }
        } else if(o1 instanceof BaseTank && o2 instanceof BaseWall) {
            return collide(o2, o1);
        }
        return true;
    }
}
