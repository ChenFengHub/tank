package com.cf.tank.proxy;

import com.cf.tank.factory.Moveable;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 19:19:46
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        new TankTimeProxy(
                new TankLogProxy(
                        new Tank()
                )
        ).move();
    }
}

interface Movable {
    void move();
}

class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank move ....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TankTimeProxy implements Movable {
    private Movable movable;
    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long begin = System.currentTimeMillis();
        movable.move();
        System.out.println("move执行花费时间：" + (System.currentTimeMillis() - begin));
    }
}

class TankLogProxy implements Movable {
    private Movable movable;
    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }
    @Override
    public void move() {
        System.out.println("log begin .....");
        movable.move();
        System.out.println("log end .....");
    }
}
