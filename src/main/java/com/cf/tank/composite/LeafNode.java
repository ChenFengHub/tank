package com.cf.tank.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:53
 */
public class LeafNode extends Node {

    public LeafNode(String name) {
        this.name = name;
    }
    @Override
    public void paint(int high) {
        String prefix = "--";
        String filling = "";
        for(int i =0; i < high; ++i) {
            filling +=prefix;
        }
        System.out.println(filling + name);
    }

}
