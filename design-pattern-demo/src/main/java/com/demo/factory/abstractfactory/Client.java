package com.demo.factory.abstractfactory;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-04-01 18:55
 */

public class Client {
    public static void main(String[] args) {
        PizzaOrder order = new PizzaOrder(new BJAbsFactory(), "greek");
    }
}
