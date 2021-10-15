package com.demo.builder;

/**
 * Director
 *
 * @author gnl
 */

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 将建造流程交给Director
     */
    public House construct() {
        this.builder.buildFunction();
        this.builder.buildWall();
        this.builder.buildRoof();
        System.out.println("All done.");
        return this.builder.buildHouse();
    }
}
