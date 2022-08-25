package com.cf.tank.facade;

import com.cf.tank.factory.tank.BaseBullet;
import com.cf.tank.factory.tank.BaseWall;
import com.cf.tank.mediator.GameObject;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-25 23:23:11
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseWall) {
            if (o1.getRectangle().intersects(o2.getRectangle())) {
                ((BaseBullet) o1).die();
            }
        } else if (o1 instanceof BaseWall && o2 instanceof BaseBullet) {
            collide(o2, o1);
        }
        return true;
    }
}
