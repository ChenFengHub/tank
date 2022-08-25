package com.cf.tank.factory.tank;

import com.cf.tank.*;
import com.cf.tank.facade.GameModel;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 14:14:12
 */
public class RectBullet extends BaseBullet {

    public static final int WIDTH = ResourceMgr.bulletL.getWidth(), HEIGH = ResourceMgr.bulletL.getHeight();

    public RectBullet(int x, int y, DirEnum dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rectangle = new Rectangle();
        rectangle.width = WIDTH;
        rectangle.height = HEIGH;
        GameModel.getInstance().getGos().add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, WIDTH, HEIGH);
        g.setColor(c);
        if(!isLive(TankFrame.GAME_WIDTH, TankFrame.GAME_HEIGHT)) {
            GameModel.getInstance().getGos().remove(this);
            return;
        }
        updateCor(SPEED);
        // 1. 用于更新区域，可用于判断与其他坦克是否有碰撞
        rectangle.x = x;
        rectangle.y = y;
    }

    public Boolean isLive(int maxWidth, int maxHeight) {
        if(!living || x < 0 || x > maxWidth || y < 0 || y > maxHeight) {
            return false;
        } else {
            return true;
        }
    }

}
