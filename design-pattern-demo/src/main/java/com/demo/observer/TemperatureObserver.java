package com.demo.observer;

/**
 * TemperatureObserver
 * @author gnl
 */

public class TemperatureObserver implements Observer {

    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        show();
    }

    public void show() {
        System.out.println("TemperatureObserver temperature: " + this.temperature);
    }
}
