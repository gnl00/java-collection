package com.demo.builder;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new CommonHouse());
        director.construct();
    }
}
