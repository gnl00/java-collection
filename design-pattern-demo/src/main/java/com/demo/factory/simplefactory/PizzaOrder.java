package com.demo.factory.simplefactory;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-03-26 14:12
 */

public class PizzaOrder {

    public PizzaOrder(String name) {
        Pizza pizza = SimpleFactory.getInstance(name);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

    }

}
