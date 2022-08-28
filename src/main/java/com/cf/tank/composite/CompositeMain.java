package com.cf.tank.composite;

import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 07:07:59
 */
public class CompositeMain {
    public static void main(String[] args) {
        NotLeafNode root = new NotLeafNode("root");
        NotLeafNode c1 = new NotLeafNode("c1");
        NotLeafNode c2 = new NotLeafNode("c2");
        NotLeafNode c3 = new NotLeafNode("c3");
        NotLeafNode c4 = new NotLeafNode("c4");

        Node l1 = new LeafNode("l1");
        Node l2 = new LeafNode("l2");
        Node l3 = new LeafNode("l3");
        Node l4 = new LeafNode("l4");

        root.add(c1);
        root.add(c2);
        root.add(c3);
        ((NotLeafNode) c3).add(c4);
        c1.add(l1);
        c2.add(l2);
        c3.add(l3);
        c4.add(l4);

        int high = 0;
        root.paint(high);
        paint(root.getChildren(), high+1);
    }

    private static void paint(List<Node> children, int high) {
        for (Node child : children) {
            child.paint(high);
            if(child instanceof NotLeafNode && ((NotLeafNode)child).hasChildren()) {
                paint(((NotLeafNode)child).getChildren(), high+1);
            }
        }
    }
}
