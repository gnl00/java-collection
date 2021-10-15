package com.demo.factory.abstractfactory;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-03-26 13:57
 */

public class BJCheesePizza extends Pizza {

    @Override
    void prepare() {
        setName("BJCheesePizza");
        System.out.println("BJCheesePizza preparing");
    }

}
