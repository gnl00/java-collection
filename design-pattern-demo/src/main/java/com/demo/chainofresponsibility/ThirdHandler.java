package com.demo.chainofresponsibility;

/**
 * ThirdHandler ConcreteHandler
 *
 * @author gnl
 */

public class ThirdHandler extends Handler {

    public ThirdHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(Request request) {
        if ( request.getDay() > 7) {
            System.out.println("****************");
            System.out.println("请求id: " + request.getId());
            System.out.println("请求type: " + request.getType());
            System.out.println("请求day(s): " + request.getDay());
            System.out.println("处理人: " + super.name);
        } else {
            // 自己不能处理，交给下一个处理者处理
            super.nextHandler.processRequest(request);
        }
    }
}
