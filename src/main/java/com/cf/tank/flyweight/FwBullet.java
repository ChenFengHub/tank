package com.cf.tank.flyweight;

import java.util.UUID;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 13:13:52
 */
public class FwBullet {
    public UUID id = UUID.randomUUID();
    public boolean living = false;

    @Override
    public String toString() {
        return "Bullet{ id=" + id + "}";
    }
}
