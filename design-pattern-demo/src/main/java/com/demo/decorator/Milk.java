package com.demo.decorator;

/**
 * Milk ConcreteDecorator
 *
 * @author gnl
 */

public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setDesc("milk");
        setPrice(2.0f);
    }
}
