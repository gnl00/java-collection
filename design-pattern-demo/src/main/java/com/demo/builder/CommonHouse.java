package com.demo.builder;

/**
 * CommonHouse
 *
 * @author gnl
 */

public class CommonHouse extends Builder{
    @Override
    void buildFunction() {
        System.out.println("CommonHouse buildFunction");
    }

    @Override
    void buildWall() {
        System.out.println("CommonHouse buildWall");
    }

    @Override
    void buildRoof() {
        System.out.println("CommonHouse buildRoof");
    }
}
