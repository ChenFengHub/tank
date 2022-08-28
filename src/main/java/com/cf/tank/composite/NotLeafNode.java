package com.cf.tank.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:57
 */
public class NotLeafNode extends Node {
    public NotLeafNode(String name) {
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

    private List<Node> children = new ArrayList<>();

    public void add(Node node) {
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }
}
