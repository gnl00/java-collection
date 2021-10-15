package com.demo.facade;

/**
 * Player SubClass
 *
 * @author gnl
 */

public class Player {

    private Player() {}

    private final static Player INSTANCE = new Player();

    public static Player getInstance() {
        return INSTANCE;
    }

    public void on() {
        System.out.println("player on");
    }
    public void off() {
        System.out.println("player off");
    }
    public void play() {
        System.out.println("player play");
    }
    public void pause() {
        System.out.println("player pause");
    }

}
