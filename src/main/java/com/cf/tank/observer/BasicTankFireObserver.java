package com.cf.tank.observer;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:25
 */
public class BasicTankFireObserver implements TankFireObserver {
    @Override
    public void fireEvent(TankFireEvent e) {
        System.out.println(e.getSource().toString() + "basic Observer fire。。。");
        e.getSource().fire();
    }
}
