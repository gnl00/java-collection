package com.demo.observer;

/**
 * ConcreteObserver
 * @author gnl
 */

public class ConcreteObserver implements Observer {

    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        show();
    }

    public void show() {
        System.out.println("ConcreteObserver temperature: " + this.temperature);
    }
}
