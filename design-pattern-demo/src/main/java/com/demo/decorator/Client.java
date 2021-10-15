package com.demo.decorator;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Decorator milk = new Milk(new OrangeJuice());
        System.out.println(milk.getDesc());
        System.out.println(milk.cost());
    }
}
