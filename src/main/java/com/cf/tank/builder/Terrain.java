package com.cf.tank.builder;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-31 07:07:16
 */
public class Terrain {
    Wall wall;
    Fort fort;
    Mine mine;
}
class Wall {
    int x,y,w,h;
    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
class Fort {
    int x, y, w, h;
    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
class Mine {
    int x, y, w, h;
    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
