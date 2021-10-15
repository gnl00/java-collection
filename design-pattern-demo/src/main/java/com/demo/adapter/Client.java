package com.demo.adapter;

/**
 * 类适配器
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        RobertDog robertDog = new RobertDog();

        robertDog.bark();
        robertDog.run();
    }
}
