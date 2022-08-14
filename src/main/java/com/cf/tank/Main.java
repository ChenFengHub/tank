package com.cf.tank;


/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-10 23:23:02
 */
public class Main {

    private static final Boolean MOVINE= true;

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        // 1. 初始化地方坦克
        for(int i =0; i < 5; ++i) {
            Tank tank = new Tank(50 + i * 80, 200, DirEnum.DOWN, tankFrame, Group.BAD);
            tank.setMoving(MOVINE);
            tankFrame.getEnemies().add(tank);
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
