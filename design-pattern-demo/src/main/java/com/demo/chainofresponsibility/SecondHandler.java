package com.demo.chainofresponsibility;

/**
 * SecondHandler ConcreteHandler
 *
 * @author gnl
 */

public class SecondHandler extends Handler {

    public SecondHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(Request request) {
        if ( request.getDay() > 3 && request.getDay() <= 7) {
            System.out.println("****************");
            System.out.println("请求id: " + request.getId());
            System.out.println("请求type: " + request.getType());
            System.out.println("请求day(s): " + request.getDay());
            System.out.println("处理人: " + super.name);
        } else {
            System.out.println( super.name + " 无法处理 " + request.getId());
            // 自己不能处理，交给下一个处理者处理
            super.nextHandler.processRequest(request);
        }
    }
}
