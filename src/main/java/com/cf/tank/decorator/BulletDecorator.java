package com.cf.tank.decorator;

import com.cf.tank.factory.tank.BaseBullet;
import com.cf.tank.mediator.GameObject;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-26 07:07:32
 */
public abstract class BulletDecorator extends BaseBullet {
    protected GameObject go;
    public BulletDecorator(GameObject go) {
        this.go = go;
    }
    @Override
    public abstract void paint(Graphics g);
}
