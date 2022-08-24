package com.cf.tank.facade;

import com.cf.tank.mediator.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
