package com.demo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject
 * @author gnl
 */

public class ConcreteSubject implements Subject {

    private float temperature;
    private List<Observer> observers;

    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        dataChanged();
    }

    @Override
    public void registerObs(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObs(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObs() {
        this.observers.forEach(obs -> {
            obs.update(this.temperature);
        });
    }

    public void dataChanged() {
        notifyObs();
    }
}
