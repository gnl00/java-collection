package com.demo.builder;

/**
 * Builder
 *
 * @author gnl
 */

public abstract class Builder {

    protected House house = new House();

    /**
     * buildFunction
     */
    abstract void buildFunction();

    /**
     * buildWall
     */
    abstract void buildWall();

    /**
     * buildRoof
     */
    abstract void buildRoof();

    public House buildHouse() {
        return house;
    }
}
