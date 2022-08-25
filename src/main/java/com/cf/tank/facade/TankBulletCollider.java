package com.cf.tank.facade;

import com.cf.tank.Explode;
import com.cf.tank.Group;
import com.cf.tank.Tank;
import com.cf.tank.factory.tank.BaseExplode;
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
             return !collideWith((BaseBullet) o1, ((BaseTank) o2));
        } else if(o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        } else {
            return true;
        }
    }

    private boolean collideWith(BaseBullet bullet, BaseTank tank) {
        if(bullet.getRectangle().intersects(tank.getRectangle()) && !tank.getGroup().equals(bullet.getGroup())) {
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGH/2 - Explode.HEIGH/2;

            createExplode(eX, eY, tank.getGroup());
            bullet.die();
            tank.die();
            return true;
        } else {
            return false;
        }
    }

    private BaseExplode createExplode(int x, int y, Group group) {
        if(Group.GOOD.equals(group)) {
            return GameModel.getInstance().defaultFactory.createExplode(x, y, group);
        } else {
            return GameModel.getInstance().defaultFactory.createExplode(x, y, group);
        }
    }
}
