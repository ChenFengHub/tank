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
    private GameModel gm = null;
    private Boolean living = true;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(()->{
            new Audio("audio/explode.wav").play();
        }).start();
        gm.getExplodes().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if(living){
            BufferedImage image = ResourceMgr.explodes[step];
            g.drawImage(image, x, y, null);
            step++;
            if(step >= 16) {
                living = false;
                gm.getExplodes().remove(this);
            }
        }
    }

}
