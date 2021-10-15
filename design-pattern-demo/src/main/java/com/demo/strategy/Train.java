package com.demo.strategy;

/**
 * Train ConcreteStrategy
 *
 * @author gnl
 */

public class Train implements Strategy {
    @Override
    public void go() {
        System.out.println("Strategy ==> Train");
    }
}
