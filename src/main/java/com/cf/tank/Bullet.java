package com.cf.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 02:02:35
 */
public class Bullet {

    public static final int BULLET_WIDTH = ResourceMgr.bulletL.getWidth(), BULLET_HEIGH = ResourceMgr.bulletL.getHeight();

    private final int SPEED = 10;
    private int x, y;
    private DirEnum dir = DirEnum.DOWN;
    private TankFrame tf = null;
    private Boolean living = true;
    private Group group = Group.ENEMY;

    public Bullet(int x, int y, DirEnum dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGH);
//        g.setColor(c);
        if(!isLive(tf.GAME_WIDTH, tf.GAME_HEIGHT)) {
            tf.getBullets().remove(this);
            return;
        }
        g.drawImage(choseBulletImage(), x, y, null);
        move();
    }

    private BufferedImage choseBulletImage() {
        switch (dir) {
            case LEFT:
                return ResourceMgr.bulletL;
            case RIGHT:
                return ResourceMgr.bulletR;
            case UP:
                return ResourceMgr.bulletU;
            case DOWN:
                return ResourceMgr.bulletD;
            default:
                return ResourceMgr.bulletL;
        }
    }

    public Boolean isLive(int maxWidth, int maxHeight) {
        if(!living || x < 0 || x > maxWidth || y < 0 || y > maxHeight) {
            return false;
        } else {
            return true;
        }
    }

    public void move(){
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void collideWith(Tank tank) {
        Rectangle b = new Rectangle(x, y, BULLET_WIDTH, BULLET_HEIGH);
        Rectangle t = new Rectangle(tank.getX(), tank.getY(), tank.TANK_WIDTH, tank.TANK_HEIGH);
        if(b.intersects(t) && !tank.getGroup().equals(group)) {
            tf.getExplodes().add(new Explode(tank.getX(), tank.getY(), tf));
            this.die();
            tank.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
