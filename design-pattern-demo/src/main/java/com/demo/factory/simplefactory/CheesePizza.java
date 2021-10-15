package com.demo.factory.simplefactory;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-03-26 13:57
 */

public class CheesePizza extends Pizza{

    private String name = "CheesePizza";

    @Override
    void prepare() {
        System.out.println(name + "pizza is preparing now...");
    }

    @Override
    void bake() {
        System.out.println(name + "pizza is baking now...");
    }

    @Override
    void cut() {
        System.out.println(name + "pizza is cutting now...");

    }

    @Override
    void box() {
        System.out.println(name + "pizza is boxing now...");
    }
}
