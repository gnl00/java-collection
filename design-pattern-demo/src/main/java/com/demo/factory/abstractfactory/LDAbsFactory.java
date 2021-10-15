package com.demo.factory.abstractfactory;

/**
 * LDAbsFactory
 *
 * @author gnl
 */

public class LDAbsFactory extends AbsFactory {
    
    @Override
    public Pizza getInstance(String name) {

        Pizza pizza = null;

        if ("greek".equals(name)) {
            pizza = new LDGreekPizza();
        } else  if("cheese".equals(name)) {
            pizza = new LDCheesePizza();
        }

        return pizza;
    }
}
