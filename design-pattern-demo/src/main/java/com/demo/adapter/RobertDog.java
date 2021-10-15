package com.demo.adapter;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-04-02 15:20
 */

public class RobertDog extends AIRobert implements Dog {
    @Override
    public void bark() {
        talk();
    }

    @Override
    public void run() {
        move();
    }
}
