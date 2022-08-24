package com.cf.tank.facade;

import com.cf.tank.PropertyMgr;
import com.cf.tank.constant.ConfigConstant;
import com.cf.tank.mediator.GameObject;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-24 08:08:28
 */
public class ColliderChain implements Collider {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        String colliderStrs = PropertyMgr.getStr(ConfigConstant.COLLIDER);
        if(!Objects.isNull(colliderStrs) && colliderStrs.length() > 0) {
            String[] names = colliderStrs.split(",");
            if(names.length > 0) {
                for(int i = 0; i< names.length;++i) {
                    try {
                        colliders.add((Collider) Class.forName(names[i]).getDeclaredConstructor().newInstance());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }

}
