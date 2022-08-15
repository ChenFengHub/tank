package com.cf.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-14 22:22:25
 */
public class PropertyMgr {
    private static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if(props == null) {
            return null;
        }
        return props.get(key);
    }

    public static Integer getInt(String key) {
        if(props == null) {
            return null;
        }
        return PropertyMgr.getStr(key) == null? null : Integer.parseInt(PropertyMgr.getStr(key));
    }

    public static String getStr(String key) {
        if(props == null) {
            return null;
        }
        return props.get(key) == null? null : props.get(key).toString();
    }

    //int getInt(key)
    //getString(key)

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));

    }

}
