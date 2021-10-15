package com.demo.mediator;

/**
 * CommonMember ConcreteColleague
 *
 * @author gnl
 * @date 2021-04-08 10:50
 */

public class CommonMember implements Colleague {

    @Override
    public void sendText() {
        System.out.println("CommonMember sendText");
    }

    @Override
    public void sendPicture() {
        throw new UnsupportedOperationException();
    }
}
