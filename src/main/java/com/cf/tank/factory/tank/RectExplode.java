package com.cf.tank.factory.tank;

import com.cf.tank.Audio;
import com.cf.tank.ResourceMgr;
import com.cf.tank.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-19 07:07:56
 */
public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGH = ResourceMgr.explodes[0].getHeight();


    private int x,y;
    private int step =0;
    private TankFrame tf = null;
    private Boolean living = true;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->{
            new Audio("audio/explode.wav").play();
        }).start();
        tf.getExplodes().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if(living){
            Color c = g.getColor();
            g.setColor(Color.RED);
            g.fillRect(x, y, 10 * step, 10 * step);
            step++;
            if(step > 5) {
                living = false;
                tf.getExplodes().remove(this);
            }
            g.setColor(c);
        }
    }
}
