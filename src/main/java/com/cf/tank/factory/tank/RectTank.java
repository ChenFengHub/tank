package com.cf.tank.factory.tank;

import com.cf.tank.*;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 14:14:12
 */
public class RectTank extends BaseTank {
    public static final int WIDTH = ResourceMgr.goodTankL.getWidth(), HEIGH = ResourceMgr.goodTankL.getHeight();

    public RectTank(int x, int y, DirEnum dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rectangle = new Rectangle();
        rectangle.height = HEIGH;
        rectangle.width = WIDTH;
    }

    @Override
    public void fire() {
        int bX = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + Tank.HEIGH/2 - Bullet.HEIGH/2;
        tf.rectFactory.createBullet(bX, bY, dir, group, tf);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 60, 50);
        g.setColor(c);

        autoAction();

        // 1. 用于更新区域，可用于判断与其他坦克是否有碰撞
        rectangle.x = x;
        rectangle.y = y;
    }


    @Override
    public void die() {
        tf.getEnemies().remove(this);
    }

}
