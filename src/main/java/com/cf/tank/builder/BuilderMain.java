package com.cf.tank.builder;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-31 07:07:25
 */
public class BuilderMain {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        // 复杂对象需要构建哪些属性，执行该方法即可，最终 build 出地图复杂对象
        // 构建者基本都是使用链式编程
        Terrain t = builder.buildFort().buildMine().buildWall().build();
    }
}
