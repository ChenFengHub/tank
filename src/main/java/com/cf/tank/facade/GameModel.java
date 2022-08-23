package com.cf.tank.facade;

import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.PropertyMgr;
import com.cf.tank.Tank;
import com.cf.tank.factory.tank.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 门面。将 TF 对坦克、子弹、爆炸的操作，都提炼到这里
 * @author: Mr.CF
 * @create: 2022-08-23 07:07:50
 */
public class GameModel {

    private List<BaseTank> enemies = new ArrayList<>();
    private List<BaseBullet> bullets = new ArrayList<>();
    private List<BaseExplode> explodes = new ArrayList<>();

    /** 全部的抽象工厂 **/
    public DefaultFactory defaultFactory = new DefaultFactory();
    public RectFactory rectFactory = new RectFactory();
    public BaseTank selfTank = defaultFactory.createTank(100, 60, DirEnum.DOWN, Group.GOOD, this);

    public void setEnemies(List<BaseTank> enemies) {
        this.enemies = enemies;
    }

    public List<BaseTank> getEnemies() {
        return enemies;
    }

    public List<BaseBullet> getBullets() {
        return bullets;
    }

    public List<BaseExplode> getExplodes() {
        return explodes;
    }

    public void paint(Graphics g) {
        paintMyTank(g);
        paintMyBullet(g);

        paintEnemies(g);

        dealCollide();
        paintExplodes(g);
    }


    private void paintExplodes(Graphics g) {
        for (int i = 0; i < explodes.size(); ++i) {
            explodes.get(i).paint(g);
        }
    }

    private void dealCollide() {
        for (int i = 0; i < bullets.size(); ++i) {
            for (int j = 0; j < enemies.size(); ++j) {
                bullets.get(i).collideWith(enemies.get(j));
            }
        }
    }

    private void paintEnemies(Graphics g) {
        for (int i = 0; i < enemies.size(); ++i) {
            BaseTank enemy = enemies.get(i);
            enemy.paint(g);
        }
    }

    private void paintMyBullet(Graphics g) {
//        bullets.forEach(bullet->{
//            bullet.paint(g);
//            if(!bullet.isLive(GAME_WIDTH, GAME_HEIGHT)) {
//                bullets.remove(bullet);
//            }
//        });
        for (int i = 0; i < bullets.size(); i++) {
            BaseBullet bullet = bullets.get(i);
            bullet.paint(g);
        }
    }

    private void paintMyTank(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + enemies.size(), 10, 90);
        g.setColor(c);

        selfTank.paint(g);
    }

}
