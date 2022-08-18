package com.cf.tank;

import com.cf.tank.strategy.DefaultFireStrategy;
import com.cf.tank.strategy.FireStrategy;
import com.cf.tank.strategy.FourDirFireStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 01:01:37
 */
public class Tank {
    public static final int WIDTH = ResourceMgr.goodTankL.getWidth(), HEIGH = ResourceMgr.goodTankL.getHeight();
    private int x;
    private int y;
    private DirEnum dir = DirEnum.DOWN;
    private static final int SPEED = 5;
    private Boolean moving = false;
    private TankFrame tf;
    private Boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    private Rectangle rectangle;
    private FireStrategy fs;

    public Tank(int x, int y, DirEnum dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
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

    public Group getGroup() {
        return group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }


    public void setDir(DirEnum dir) {
        this.dir = dir;
        move();
    }

    public void fire() {
        fs.fire(this);
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                x = x < 0 ? 0 : x;
                break;
            case RIGHT:
                x += SPEED;
                x = x > tf.GAME_WIDTH - 50 ? tf.GAME_WIDTH - 50 : x;
                break;
            case UP:
                y -= SPEED;
                y = y < 0 ? 0 : y;
                break;
            case DOWN:
                y += SPEED;
                y = y > tf.GAME_HEIGHT - 50 ? tf.GAME_HEIGHT - 50 : y;
                break;
            default:
                break;
        }
    }


    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        System.out.println("pait x, y:" + x + "   " + y);
//        g.fillRect(x, y, 60, 50);
//        g.setColor(c);
        if (!living) {
            tf.getEnemies().remove(this);
            return;
        }
        g.drawImage(choseTankImage(), x, y, null);

        autoAction();

        // 1. 用于更新区域，可用于判断与其他坦克是否有碰撞
        rectangle.x = x;
        rectangle.y = y;
    }

    private void autoAction() {
        if (group.equals(Group.BAD)) {
            randomFire();
            randomDir();
            move();
        }
    }

    private void randomFire() {
        if (random.nextInt(10) > 7) {
            fire();
        }
    }

    private void randomDir() {
        if (random.nextInt(10) > 7) {
//            int randomDir = random.nextInt(4);
//            switch (randomDir) {
//                case 0:
//                    dir = DirEnum.UP;
//                    break;
//                case 1:
//                    dir = DirEnum.DOWN;
//                    break;
//                case 2:
//                    dir = DirEnum.LEFT;
//                    break;
//                case 3:
//                    dir = DirEnum.RIGHT;
//                    break;
//                default:
//                    dir = DirEnum.DOWN;
//                    break;
//            }
            // 简化写法
            dir = DirEnum.values()[random.nextInt(4)];
        }
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

    public void die() {
        living = false;
    }

    public Boolean getLiving() {
        return living;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public DirEnum getDir() {
        return dir;
    }

    public TankFrame getTf() {
        return tf;
    }
}
