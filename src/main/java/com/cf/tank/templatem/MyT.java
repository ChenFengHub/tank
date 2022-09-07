package com.cf.tank.templatem;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-07 08:08:02
 */
public class MyT extends AbstractTemplate {

    @Override
    protected void paint() {
        System.out.println("insert my pain");
    }

    public static void main(String[] args) {
        MyT myT = new MyT();
        myT.template();
    }

}
