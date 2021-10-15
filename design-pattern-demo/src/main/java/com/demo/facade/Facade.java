package com.demo.facade;

/**
 * Facade
 * @author gnl
 */

public class Facade {

    private Player player = Player.getInstance();
    private Screen screen = Screen.getInstance();
    private Light light = Light.getInstance();

    public void start() {
        screen.down();
        player.on();
        light.on();
    }
    public void play() {
        player.play();
        light.focus();
    }
    public void pause() {
        player.pause();
        light.fade();
    }
    public void end() {
        player.off();
        screen.up();
        light.off();
    }

}
