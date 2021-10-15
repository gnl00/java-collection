package com.demo.mediator;

/**
 * VipMember ConcreteColleague
 *
 * @author gnl
 */

public class VipMember implements Colleague {

    @Override
    public void sendText() {
        System.out.println("VipMember sendText");
    }

    @Override
    public void sendPicture() {
        System.out.println("VipMember sendPicture");
    }
}
