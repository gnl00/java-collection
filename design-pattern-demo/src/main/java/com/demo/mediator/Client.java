package com.demo.mediator;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();

        CommonMember commonMember = new CommonMember();
        VipMember vipMember = new VipMember();

        mediator.register(commonMember, "common");
        mediator.register(vipMember, "vip");

        mediator.getMessage("common");
        mediator.getMessage("vip");

    }
}
