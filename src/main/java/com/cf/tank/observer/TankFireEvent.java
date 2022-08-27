package com.cf.tank.observer;

import com.cf.tank.factory.tank.BaseTank;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 06:06:56
 */
public class TankFireEvent {
    private BaseTank tank;
    public BaseTank getSource() {
        return tank;
    }
    public TankFireEvent(BaseTank tank) {
        this.tank = tank;
    }
}
