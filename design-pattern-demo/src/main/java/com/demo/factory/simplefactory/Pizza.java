package com.demo.factory.simplefactory;

/**
 * abstract Pizza
 *
 * @author gnl
 */

public abstract class Pizza {

    /**
     * prepare
     * @return void
     */
    abstract void prepare();

    /**
     * bake
     * @return void
     */
    abstract void bake();

    /**
     * cut
     * @return void
     */
    abstract void cut();

    /**
     * box
     * @return void
     */
    abstract void box();

}
