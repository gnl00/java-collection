package com.demo.flyweight;

/**
 * ConcreteWebSite ConcreteFlyweight
 *
 * @author gnl
 */

public class ConcreteWebSite extends WebSite {

    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void controller(String admin) {
        System.out.println("WebSite type: "+type + " | WebSite controller: " + admin);
    }
}
