package com.cf.tank.flyweight;

import com.cf.tank.Bullet;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 13:13:49
 */
public class FwBulletPool {
    private List<FwBullet> bullets = new ArrayList<>();

    {
        System.out.println("1方法体");
        for (int i = 0; i < 5; i++) {
            bullets.add(new FwBullet());
        }
    }

    public FwBulletPool() {
        System.out.println("2构造函数");
    }

    public FwBullet getBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            FwBullet b = bullets.get(i);
            if (!b.living) {
                b.living = true;
                return b;
            }
        }
        FwBullet fwBullet = new FwBullet();
        bullets.add(fwBullet);
        return fwBullet;
    }

    public static void main(String[] args) {
        FwBulletPool bp = new FwBulletPool();
        for (int i = 0; i < 10; i++) {
            FwBullet b = bp.getBullet();
            System.out.println(b);
            // 对象使用完成，living 改为 false
            b.living = false;
        }
    }
}
