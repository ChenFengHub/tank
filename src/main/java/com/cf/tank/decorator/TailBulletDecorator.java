package com.cf.tank.decorator;

import com.cf.tank.facade.GameModel;
import com.cf.tank.factory.tank.BaseBullet;
import com.cf.tank.mediator.GameObject;

import java.awt.*;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-26 07:07:39
 */
public class TailBulletDecorator extends BulletDecorator {

    public TailBulletDecorator(GameObject go) {
        super(go);
        this.x = go.getX();
        this.y = go.getY();
        this.x = go.getX();
        this.y = go.getY();
        this.group = ((BaseBullet)go).getGroup();
        this.rectangle = go.getRectangle();
        GameModel.getInstance().getGos().remove(go);
        GameModel.getInstance().getGos().add(this);
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.getX(), go.getY(), go.getX() + go.getWidth(), go.getY() + go.getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
