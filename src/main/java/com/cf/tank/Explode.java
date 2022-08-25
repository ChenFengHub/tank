package com.cf.tank;

import com.cf.tank.facade.GameModel;
import com.cf.tank.factory.tank.BaseExplode;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 20:20:20
 */
public class Explode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGH = ResourceMgr.explodes[0].getHeight();


    private int x,y;
    private int step =0;
    private Boolean living = true;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        new Thread(()->{
            new Audio("audio/explode.wav").play();
        }).start();
        GameModel.getInstance().getGos().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if(living){
            BufferedImage image = ResourceMgr.explodes[step];
            g.drawImage(image, x, y, null);
            step++;
            if(step >= 16) {
                living = false;
                GameModel.getInstance().getGos().remove(this);
            }
        }
    }

}
