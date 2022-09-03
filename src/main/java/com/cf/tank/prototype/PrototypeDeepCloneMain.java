package com.cf.tank.prototype;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-09-03 16:16:06
 */
public class PrototypeDeepCloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 深克隆
        PersonDeep p1 = new PersonDeep();
        PersonDeep p2 = (PersonDeep) p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "change";
        System.out.println(p2.loc);
    }
}

class LocationDeep implements Cloneable {
    String street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
    public LocationDeep(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class PersonDeep implements Cloneable {
    int age = 8;
    int score = 100;
    LocationDeep loc = new LocationDeep("建设路", 22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        PersonDeep person = (PersonDeep) super.clone();
        person.loc = (LocationDeep)person.loc.clone();
        return person;
    }
}