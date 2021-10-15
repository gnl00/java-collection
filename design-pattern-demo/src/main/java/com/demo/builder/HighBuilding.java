package com.demo.builder;

/**
 * HighBuilding
 *
 * @author gnl
 */

public class HighBuilding extends Builder{
    @Override
    void buildFunction() {
        System.out.println("HighBuilding buildFunction");
    }

    @Override
    void buildWall() {
        System.out.println("HighBuilding buildWall");
    }

    @Override
    void buildRoof() {
        System.out.println("HighBuilding buildRoof");
    }
}
