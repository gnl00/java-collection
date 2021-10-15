package com.demo.adapter;

/**
 * AIRobert
 *
 * @author gnl
 */

public class AIRobert implements Robert {
    @Override
    public void talk() {
        System.out.println("this robert is making some noise");
    }

    @Override
    public void move() {
        System.out.println("this robert is moving");
    }
}
