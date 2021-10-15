package com.demo.facade;

/**
 * Light SubClass
 *
 * @author gnl
 */

public class Light {

    private Light() {}

    private final static Light INSTANCE = new Light();

    public static Light getInstance() {
        return INSTANCE;
    }

    public void on() {
        System.out.println("Light on");
    }

    public void off() {
        System.out.println("Light off");
    }

    public void focus() {
        System.out.println("Light focus");
    }

    public void fade() {
        System.out.println("Light fade");
    }

}
