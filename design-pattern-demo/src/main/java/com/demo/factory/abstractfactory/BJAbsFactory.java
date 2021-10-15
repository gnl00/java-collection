package com.demo.factory.abstractfactory;

/**
 * BJAbsFactory
 *
 * @author gnl
 */

public class BJAbsFactory extends AbsFactory {

    @Override
    public Pizza getInstance(String name) {

        Pizza pizza = null;

        if ("greek".equals(name)) {
            pizza = new BJGreekPizza();
        } else  if("cheese".equals(name)) {
            pizza = new BJCheesePizza();
        }

        return pizza;
    }
}
