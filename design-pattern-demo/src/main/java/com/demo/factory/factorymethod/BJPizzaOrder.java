package com.demo.factory.factorymethod;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-04-01 14:33
 */

public class BJPizzaOrder extends PizzaOrder {

    public BJPizzaOrder(String name) {
        super(name);
    }

    @Override
    Pizza getInstance(String name) {

        if (name.equals("cheese")) {
            return new BJCheesePizza();
        } else if ("greek".equals(name)) {
            return new BJGreekPizza();
        } else {
            return null;
        }
    }
}
