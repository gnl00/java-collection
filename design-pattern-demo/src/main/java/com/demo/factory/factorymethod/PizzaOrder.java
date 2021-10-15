package com.demo.factory.factorymethod;

/**
 * TODO
 *
 * @author gnl
 */

public abstract class PizzaOrder {

    abstract Pizza getInstance(String name);

    public PizzaOrder(String name) {
        Pizza pizza = getInstance(name);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

    }

}
