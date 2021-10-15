package com.demo.factory.abstractfactory;

/**
 * GreekPizza
 *
 * @author gnl
 */

public class LDGreekPizza extends Pizza {

    @Override
    void prepare() {
        setName("BJGreekPizza");
        System.out.println("BJGreekPizza preparing");
    }

}
