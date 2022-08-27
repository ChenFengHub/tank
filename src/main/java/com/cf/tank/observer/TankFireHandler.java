package com.cf.tank.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:00
 */
public class TankFireHandler {
    private static TankFireHandler INSTANCE = new TankFireHandler();
    List<TankFireObserver> fireObservers = new ArrayList<>();

    public void fire(TankFireEvent e) {
        for(TankFireObserver fireObserver : fireObservers) {
            fireObserver.fireEvent(e);
        }
    }

    public void addListenet(TankFireObserver ob) {
        fireObservers.add(ob);
    }

    private TankFireHandler() {
    }
    public static TankFireHandler getInstance() {
        return INSTANCE;
    }

}
