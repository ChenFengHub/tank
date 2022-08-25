package com.cf.tank.factory.tank;

import com.cf.tank.mediator.GameObject;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 21:21:54
 */
public abstract class BaseWall extends GameObject {
    protected final int WIDTH = 100, HEIGH = 30;
    public BaseWall() {
        rectangle = new Rectangle();
        rectangle.height = HEIGH;
        rectangle.width = WIDTH;
    }
    public BaseWall(int x, int y) {
        rectangle = new Rectangle();
        rectangle.height = HEIGH;
        rectangle.width = WIDTH;
        rectangle.x = x;
        rectangle.y = y;
    }
    public boolean collideWith(BaseTank tank) {
        if(rectangle.intersects(tank.getRectangle())) {
            return true;
        } else {
            return false;
        }
    }

}
