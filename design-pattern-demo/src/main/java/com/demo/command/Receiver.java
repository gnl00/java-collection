package com.demo.command;

/**
 * Receiver 接收者
 *
 * @author gnl
 */

public class Receiver {

    public void execute(String function) {
        System.out.println("执行功能: " + function);
    }

    public void undo(String function) {
        System.out.println("撤销功能: " + function);
    }

}
