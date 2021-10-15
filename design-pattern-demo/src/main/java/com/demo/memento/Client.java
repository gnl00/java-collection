package com.demo.memento;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("state--0 power--100");
        careTaker.addMemento(originator.saveMementoState());
        originator.setState("state--1 power--90");
        careTaker.addMemento(originator.saveMementoState());
        originator.setState("state--2 power--50");
        careTaker.addMemento(originator.saveMementoState());

        String state_now = "";

        System.out.println("========当前状态========");
        state_now = originator.getState();
        System.out.println(state_now);

        System.out.println("========恢复状态0========");
        originator.getMementoState(careTaker.getMemento(0));
        String state_0 = originator.getState();
        System.out.println(state_0);

        System.out.println("========当前状态========");
        state_now = originator.getState();
        System.out.println(state_now);


    }
}
