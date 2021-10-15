package com.demo.factory.abstractfactory;

/**
 * TODO
 *
 * @author gnl
 */

public class PizzaOrder {

    AbsFactory factory;
    private String name;

    public PizzaOrder(AbsFactory factory, String name) {
        this.factory = factory;
        this.name = name;
        Pizza pizza  = this.factory.getInstance(this.name);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

    }


}
