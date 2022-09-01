package com.cf.tank.bride;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-02 07:07:31
 */
public class BridgeMain {
    public static void main(String[] args) {
        GG me = new GG();
        me.name = "cf";
        MM you = new MM();
        you.name = "clh";
        me.chase(you);
    }
}
class Book extends GiftImpl{
}
class Flower extends GiftImpl{
}
abstract class Gift {
    GiftImpl gift;
}
class GiftImpl {
}
class MM {
    public String name;
}
class WarmGift extends Gift {
    public  WarmGift(GiftImpl gift) {
        this.gift = gift;
    }

    public void warmDo() {
        System.out.println("so warm");
        this.gift.toString();
    }
}
class WildGift extends Gift {
    public WildGift(GiftImpl gift) {
        this.gift = gift;
    }
}
class GG {
    public String name;
    /** 哥哥追求美眉的方法 **/
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }
    public void give(MM mm, Gift g) {
        System.out.println(name + " give gitf:" + g.toString() + " to：" + mm.name);
    }
}
