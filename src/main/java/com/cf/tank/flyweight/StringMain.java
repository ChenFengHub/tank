package com.cf.tank.flyweight;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-28 14:14:09
 */
public class StringMain {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);                     // true
        System.out.println(s1 == s3);                     // false
        System.out.println(s1 == s3.intern());            // true
        System.out.println(s3.intern() == s4.intern());   // true
    }
}
