package com.cf.tank.mediator;

import java.awt.*;
import java.io.Serializable;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 08:08:04
 */
public abstract class GameObject implements Serializable {
    protected Rectangle rectangle;
    protected int x, y;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

    public Rectangle getRectangle() {
        return rectangle;
    }
}
