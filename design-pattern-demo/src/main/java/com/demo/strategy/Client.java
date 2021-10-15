package com.demo.strategy;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        Plane plane = new Plane();
        context.setStrategy(plane);
        context.go();

        Bike bike = new Bike();
        context.setStrategy(bike);
        context.go();
    }
}
