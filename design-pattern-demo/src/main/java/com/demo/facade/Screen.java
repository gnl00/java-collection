package com.demo.facade;

/**
 * Screen SubClass
 *
 * @author gnl
 */

public class Screen {

    private Screen() {}

    private final static Screen INSTANCE = new Screen();

    public static Screen getInstance() {
        return INSTANCE;
    }

    public void down() {
        System.out.println("Screen down");
    }

    public void up() {
        System.out.println("Screen up");
    }

}
