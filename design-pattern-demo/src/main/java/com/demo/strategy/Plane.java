package com.demo.strategy;

/**
 * Plane ConcreteStrategy
 *
 * @author gnl
 */

public class Plane implements Strategy {
    @Override
    public void go() {
        System.out.println("Strategy ==> Plane");
    }
}
