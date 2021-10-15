package com.demo.strategy;

/**
 * Bike ConcreteStrategy
 *
 * @author gnl
 */

public class Bike implements Strategy {
    @Override
    public void go() {
        System.out.println("Strategy ==> Bike");
    }
}
