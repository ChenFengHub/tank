package com.cf.tank;


import com.cf.tank.factory.tank.BaseTank;
import com.cf.tank.factory.tank.DefaultFactory;
import com.cf.tank.factory.tank.RectFactory;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-10 23:23:02
 */
public class Main {

    private static final Boolean MOVINE = true;

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        // 1. 初始化地方坦克

//        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
