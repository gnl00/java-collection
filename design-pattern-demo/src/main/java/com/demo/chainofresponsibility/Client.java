package com.demo.chainofresponsibility;

/**
 * Client
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Request request = new Request(1000, "请假", 12);
        Request request2 = new Request(1001, "请假", 3);

        FirstHandler firstHandler = new FirstHandler("组长");
        SecondHandler secondHandler = new SecondHandler("主管");
        ThirdHandler thirdHandler = new ThirdHandler("经理");

        firstHandler.setNextHandler(secondHandler);
        secondHandler.setNextHandler(thirdHandler);

        firstHandler.processRequest(request);
        firstHandler.processRequest(request2);

    }
}
