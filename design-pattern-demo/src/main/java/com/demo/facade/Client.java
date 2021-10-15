package com.demo.facade;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.start();
        System.out.println("===============");

        facade.play();
        System.out.println("===============");

        facade.pause();
        System.out.println("===============");

        facade.end();
    }
}
