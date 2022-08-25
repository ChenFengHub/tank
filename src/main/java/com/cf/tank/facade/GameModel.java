package com.cf.tank.facade;

import com.cf.tank.DirEnum;
import com.cf.tank.Group;
import com.cf.tank.PropertyMgr;
import com.cf.tank.Wall;
import com.cf.tank.constant.ConfigConstant;
import com.cf.tank.mediator.GameObject;
import com.cf.tank.factory.tank.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 门面。将 TF 对坦克、子弹、爆炸的操作，都提炼到这里
 * @author: Mr.CF
 * @create: 2022-08-23 07:07:50
 */
public class GameModel {
    private static GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    private List<GameObject> gos = new LinkedList<>();
    private ColliderChain colliderChain = new ColliderChain();

    /**
     * 全部的抽象工厂
     **/
    public DefaultFactory defaultFactory = new DefaultFactory();
    public RectFactory rectFactory = new RectFactory();
    public GameObject selfTank = defaultFactory.createTank(100, 60, DirEnum.DOWN, Group.GOOD);

    public void setGos(List<GameObject> gos) {
        this.gos = gos;
    }

    public List<GameObject> getGos() {
        return gos;
    }

    private void init() {
        // 1.初始化地方坦克
        Integer initTankCount = PropertyMgr.getInt(ConfigConstant.IINIT_TANK_COUNT);
        for (int i = 0; i < initTankCount; ++i) {
            BaseTank tank = defaultFactory.createTank(50 + i * 80, 200, DirEnum.DOWN, Group.BAD);
            gos.add(tank);
        }
        // 2. 初始化墙壁
        Integer initWallCount = PropertyMgr.getInt(ConfigConstant.WALL);
        for (int i = 0; i < initWallCount; ++i) {
            gos.add(new Wall(200+40* i, 50 *i));
        }
    }

    private GameModel() {

    }

    /**
     * 单例模式，解耦合。其他类就不需要传入 GameModel 对象，直接使用 GameModel.getInstance() 单例即可
     * @return
     */
    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void paint(Graphics g) {
        paintBulletCountAndEnemyTankCount(g);
        paintMyTank(g);
        paintGo(g);

//        paintMyBullet(g);
//        paintEnemies(g);
//        dealCollide();
//        paintExplodes(g);
    }

    private void paintBulletCountAndEnemyTankCount(Graphics g) {
        int enemyCount = 0;
        int bulletCount = 0;
        for(int i = 0; i<gos.size(); i++) {
            if(gos.get(i) instanceof BaseTank && Group.BAD.equals(((BaseTank) gos.get(i)).getGroup())) {
                enemyCount++;
            }
            if(gos.get(i) instanceof BaseBullet) {
                bulletCount++;
            }
        }
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("敌军数目：" + enemyCount, 10 , 50);
        g.drawString("子弹数目：" + bulletCount, 10, 80);
        g.setColor(c);
    }


    private void paintGo(Graphics g) {
        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
            for (int j = i + 1; j < gos.size(); j++) {
                colliderChain.collide(gos.get(i), gos.get(j));
            }
        }
    }


//    private void paintExplodes(Graphics g) {
//        for (int i = 0; i < explodes.size(); ++i) {
//            explodes.get(i).paint(g);
//        }
//    }
//
//    private void dealCollide() {
//        for (int i = 0; i < bullets.size(); ++i) {
//            for (int j = 0; j < enemies.size(); ++j) {
//                bullets.get(i).collideWith(enemies.get(j));
//            }
//        }
//    }
//
//    private void paintEnemies(Graphics g) {
//        for (int i = 0; i < enemies.size(); ++i) {
//            BaseTank enemy = enemies.get(i);
//            enemy.paint(g);
//        }
//    }
//
//    private void paintMyBullet(Graphics g) {
////        bullets.forEach(bullet->{
////            bullet.paint(g);
////            if(!bullet.isLive(GAME_WIDTH, GAME_HEIGHT)) {
////                bullets.remove(bullet);
////            }
////        });
//        for (int i = 0; i < bullets.size(); i++) {
//            BaseBullet bullet = bullets.get(i);
//            bullet.paint(g);
//        }
//    }

    private void paintMyTank(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);
        selfTank.paint(g);
    }

}
