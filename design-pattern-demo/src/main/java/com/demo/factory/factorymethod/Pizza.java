package com.demo.factory.factorymethod;

/**
 * abstract Pizza
 *
 * @author gnl
 */

public abstract class Pizza {

    protected String name;

    /**
     * prepare
     * @return void
     */
    abstract void prepare();

    /**
     * bake
     * @return void
     */
    public void bake() {
        System.out.println(name + " " + "baking");
    }

    /**
     * cut
     * @return void
     */
    public void cut() {
        System.out.println(name + " " + "cutting");
    }

    /**
     * box
     * @return void
     */
    public void box() {
        System.out.println(name + " " + "boxing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
