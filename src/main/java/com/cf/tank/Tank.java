package com.cf.tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 01:01:37
 */
public class Tank {
    public final int TANK_WIDTH = ResourceMgr.tankL.getWidth(), TANK_HEIGH = ResourceMgr.tankL.getHeight();
    private int x;
    private int y;
    private DirEnum dir = DirEnum.DOWN;
    private static final int SPEED = 5;
    private Boolean moving = false;
    private TankFrame tf;
    private Boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();

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
        int bX = x + TANK_WIDTH / 2 - Bullet.BULLET_WIDTH / 2;
        int bY = y + TANK_HEIGH / 2 - Bullet.BULLET_HEIGH / 2;
        Bullet bullet = new Bullet(bX, bY, dir, tf, group);
        tf.addBullet(bullet);
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
                x = x > tf.GAME_WIDTH -50? tf.GAME_WIDTH -50: x;
                break;
            case UP:
                y -= SPEED;
                y = y < 0 ? 0 : y;
                break;
            case DOWN:
                y += SPEED;
                y = y > tf.GAME_HEIGHT-50 ? tf.GAME_HEIGHT-50 : y;
                break;
            default:
                break;
        }
    }


    public Tank(int x, int y, DirEnum dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
                return ResourceMgr.tankL;
            case RIGHT:
                return ResourceMgr.tankR;
            case UP:
                return ResourceMgr.tankU;
            case DOWN:
                return ResourceMgr.tankD;
            default:
                return ResourceMgr.tankL;
        }
    }

    public void die() {
        living = false;
    }

    public Boolean getLiving() {
        return living;
    }
}
