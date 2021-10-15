package com.demo.strategy;

/**
 * Context
 * @author gnl
 */

public class Context {

    private Strategy strategy;

    public Context() {
        System.out.println("go for trip ~~");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void go() {
        this.strategy.go();
    }
}
