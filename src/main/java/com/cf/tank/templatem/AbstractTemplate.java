package com.cf.tank.templatem;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-07 08:08:00
 */
public abstract class AbstractTemplate {

    protected abstract void paint();

    private void doBegin() {
        System.out.println("do begin");
    }
    private void doEnd() {
        System.out.println("do end");
    }
    public void template() {
        doBegin();
        paint();
        doEnd();
    }
}


