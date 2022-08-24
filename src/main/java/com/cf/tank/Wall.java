package com.cf.tank;

import com.cf.tank.factory.tank.BaseWall;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 21:21:39
 */
public class Wall extends BaseWall {
    public Wall(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGH);
        g.setColor(c);
    }
}
