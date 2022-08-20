package com.cf.tank.factory.tank;

import com.cf.tank.*;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:29
 */
public abstract class BaseBullet {
    protected final int SPEED = 10;
    protected int x, y;
    protected DirEnum dir = DirEnum.DOWN;
    protected TankFrame tf = null;
    protected Boolean living = true;
    protected Group group = Group.BAD;
    protected Rectangle rectangle;

    public void collideWith(BaseTank tank) {
        if(rectangle.intersects(tank.getRectangle()) && !tank.getGroup().equals(group)) {
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGH/2 - Explode.HEIGH/2;

            createExplode(eX, eY, group, tf);
            // tf.gf.createExplode(eX, eY, group, tf);
            this.die();
            tank.die();
        }
    }

    protected abstract BaseExplode createExplode(int x, int y, Group group, TankFrame tf);

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

    public abstract void paint(Graphics g);
    public void die() {
        this.living = false;
    }
}
