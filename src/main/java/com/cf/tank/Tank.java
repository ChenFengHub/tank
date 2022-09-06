package com.cf.tank;

import com.cf.tank.facade.GameModel;
import com.cf.tank.factory.tank.BaseTank;
import com.cf.tank.strategy.FireStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 01:01:37
 */
public class Tank extends BaseTank {
    public static final int WIDTH = ResourceMgr.goodTankL.getWidth(), HEIGH = ResourceMgr.goodTankL.getHeight();

    private static final int SPEED = 5;
//    private transient FireStrategy fs;
    private transient FireStrategy fs;

    public Tank(int x, int y, DirEnum dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rectangle = new Rectangle();
        rectangle.height = HEIGH;
        rectangle.width = WIDTH;
        try {
            if (Group.GOOD.equals(group)) {
                fs = (FireStrategy) Class.forName(PropertyMgr.getStr("goodFS")).getDeclaredConstructor().newInstance();
            } else {
                fs = (FireStrategy) Class.forName(PropertyMgr.getStr("badFS")).newInstance();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
        updateCoordinate(SPEED);
    }

    @Override
    public void fire() {
        int bX = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + Tank.HEIGH/2 - Bullet.HEIGH/2;
        GameModel.getInstance().defaultFactory.createBullet(bX, bY, dir, group);
    }

    @Override
    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        System.out.println("pait x, y:" + x + "   " + y);
//        g.fillRect(x, y, 60, 50);
//        g.setColor(c);
        g.drawImage(choseTankImage(), x, y, null);

        autoAction();

        // 1. 用于更新区域，可用于判断与其他坦克是否有碰撞
        rectangle.x = x;
        rectangle.y = y;

    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGH;
    }


    private BufferedImage choseTankImage() {
        switch (dir) {
            case LEFT:
                return group.equals(Group.GOOD) ? ResourceMgr.goodTankL : ResourceMgr.badTankL;
            case RIGHT:
                return group.equals(Group.GOOD) ? ResourceMgr.goodTankR : ResourceMgr.badTankR;
            case UP:
                return group.equals(Group.GOOD) ? ResourceMgr.goodTankU : ResourceMgr.badTankU;
            case DOWN:
                return group.equals(Group.GOOD) ? ResourceMgr.goodTankD : ResourceMgr.badTankD;
            default:
                return group.equals(Group.GOOD) ? ResourceMgr.goodTankL : ResourceMgr.badTankL;
        }
    }

    @Override
    public void die() {
        GameModel.getInstance().getGos().remove(this);
    }

    public DirEnum getDir() {
        return dir;
    }

}
