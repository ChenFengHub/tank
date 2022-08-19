package com.cf.tank.factory.tank;


import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.TankFrame;

import java.awt.*;
import java.util.Random;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:28
 */
public abstract class BaseTank {
    private static final int SPEED = 5;
    private Random random = new Random();

    protected int x;
    protected int y;
    protected Group group = Group.BAD;
    protected Rectangle rectangle;
    protected TankFrame tf;
    protected DirEnum dir = DirEnum.DOWN;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    protected void autoAction() {
        if (group.equals(Group.BAD)) {
            randomFire();
            randomDir();
            updateCoordinate(SPEED);
        }
    }

    protected void randomFire() {
        if (random.nextInt(10) > 7) {
            fire();
        }
    }

    protected void randomDir() {
        if (random.nextInt(10) > 7) {
            // 简化写法
            dir = DirEnum.values()[random.nextInt(4)];
        }
    }

    protected void updateCoordinate(int speed) {
        switch (dir) {
            case LEFT:
                x -= speed;
                x = x < 0 ? 0 : x;
                break;
            case RIGHT:
                x += speed;
                x = x > tf.GAME_WIDTH - 50 ? tf.GAME_WIDTH - 50 : x;
                break;
            case UP:
                y -= speed;
                y = y < 0 ? 0 : y;
                break;
            case DOWN:
                y += speed;
                y = y > tf.GAME_HEIGHT - 50 ? tf.GAME_HEIGHT - 50 : y;
                break;
            default:
                break;
        }
    }

    public abstract void fire();

    public abstract void paint(Graphics g);

    public abstract void die();
}
