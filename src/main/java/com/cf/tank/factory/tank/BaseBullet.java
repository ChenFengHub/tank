package com.cf.tank.factory.tank;

import com.cf.tank.*;
import com.cf.tank.mediator.GameObject;
import com.cf.tank.facade.GameModel;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:29
 */
public abstract class BaseBullet extends GameObject {
    protected final int SPEED = 10;
    protected DirEnum dir = DirEnum.DOWN;
    protected GameModel gm = null;
    protected Boolean living = true;
    protected Group group = Group.BAD;
    protected Rectangle rectangle;

    public boolean collideWith(BaseTank tank) {
        if(rectangle.intersects(tank.getRectangle()) && !tank.getGroup().equals(group)) {
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGH/2 - Explode.HEIGH/2;

            createExplode(eX, eY, group, gm);
            // tf.gf.createExplode(eX, eY, group, tf);
            this.die();
            tank.die();
            return true;
        } else {
            return false;
        }
    }

    protected abstract BaseExplode createExplode(int x, int y, Group group, GameModel gm);

    protected void updateCor(int speed){
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
    }

    public void die() {
        this.living = false;
    }
}
