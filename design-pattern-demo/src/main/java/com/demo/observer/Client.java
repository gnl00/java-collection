package com.demo.observer;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {

        ConcreteObserver observer = new ConcreteObserver();
        TemperatureObserver tObserver = new TemperatureObserver();

        ConcreteSubject subject = new ConcreteSubject();

        subject.registerObs(observer);
        subject.registerObs(tObserver);

        subject.setTemperature(25.3f);

    }
}
