package com.demo.decorator;

/**
 * Juice ConcreteComponent
 *
 * @author gnl
 */

public class Juice extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
