package com.demo.factory.simplefactory;

/**
 * GreekPizza
 *
 * @author gnl
 */

public class GreekPizza extends Pizza {

    private String name = "GreekPizza";

    public GreekPizza() {
    }

    @Override
    void prepare() {
        System.out.println(name + " pizza is preparing now...");
    }

    @Override
    void bake() {
        System.out.println(name + " pizza is baking now...");
    }

    @Override
    void cut() {
        System.out.println(name + " pizza is cutting now...");

    }

    @Override
    void box() {
        System.out.println(name + " pizza is boxing now...");
    }
}
