package com.cf.tank.mediator;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 08:08:04
 */
public abstract class GameObject {
    protected Rectangle rectangle;
    protected int x, y;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    public abstract void paint(Graphics g);

    public Rectangle getRectangle() {
        return rectangle;
    }
}
