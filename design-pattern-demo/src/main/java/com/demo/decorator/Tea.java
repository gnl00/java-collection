package com.demo.decorator;

/**
 * Tea ConcreteDecorator
 *
 * @author gnl
 */

public class Tea extends Decorator {

    public Tea(Drink drink) {
        super(drink);
        setDesc("tea");
        setPrice(1.5f);
    }
}
