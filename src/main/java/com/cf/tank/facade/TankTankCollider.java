package com.cf.tank.facade;

import com.cf.tank.mediator.GameObject;
import com.cf.tank.factory.tank.BaseTank;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 08:08:23
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseTank) {
            if(((BaseTank) o1).getRectangle().intersects(((BaseTank) o2).getRectangle())) {
                ((BaseTank) o1).retreat();
                ((BaseTank) o2).retreat();
            } else {
                ((BaseTank) o1).restoreXY();
                ((BaseTank) o2).restoreXY();
            }
        }
        return true;
    }
}
