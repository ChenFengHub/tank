package com.cf.tank.builder;

/**
 * @program: design-pattern-tank
 * @description: 构建器接口。包括：每个部分的构建部分 + 构建器
 * @author: Mr.CF
 * @create: 2022-08-31 07:07:19
 */
public interface TerrainBuilder {
    TerrainBuilder buildWall();
    TerrainBuilder buildFort();
    TerrainBuilder buildMine();
    Terrain build();
}
