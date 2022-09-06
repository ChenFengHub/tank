package com.cf.tank.strategy;

import com.cf.tank.factory.tank.BaseTank;

import java.io.Serializable;

public interface FireStrategy extends Serializable {
    void fire(BaseTank tank);
}
