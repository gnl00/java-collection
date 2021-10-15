package com.demo.factory.simplefactory;

/**
 * SimpleFactory
 *
 * @author gnl
 */

public class SimpleFactory {
    public static Pizza getInstance(String name) {

        Pizza pizza = null;

        while (null != name || !"".equals(name)) {
            if ("greek".equals(name)) {
                pizza = new GreekPizza();
                break;
            } else if ("cheese".equals(name)) {
                pizza = new CheesePizza();
                break;
            } else {
                break;
            }
        }

        return pizza;
    }
}
