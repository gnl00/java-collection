package com.demo.chainofresponsibility;

/**
 * Handler
 * @author gnl
 */

public abstract class Handler {

    protected Handler nextHandler;

    protected String name;

    /**
     * processRequest
     * @param request
     * @return void
     * @author gnl
     */
    public abstract void processRequest(Request request);

    public Handler(String name) {
        this.name = name;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
