package com.demo.bridge;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Computer laptop = new Laptop(new Lenovo());
        laptop.sale();

        Desktop desktop = new Desktop(new Dell());
        desktop.sale();
    }
}
