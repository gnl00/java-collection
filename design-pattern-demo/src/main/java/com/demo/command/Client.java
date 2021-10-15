package com.demo.command;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Invoker helpInvoker = new Invoker();
        Invoker functionInvoker = new Invoker();

        Receiver receiver = new Receiver();

        Command helpCommand = new DoCommand(receiver, "打开帮助手册");
        Command functionCommand = new DoCommand(receiver, "执行某功能");

        helpInvoker.setCommand(helpCommand);
        helpInvoker.setUndoCommand(helpCommand);

        functionInvoker.setCommand(functionCommand);

        helpInvoker.executeCommand();
        helpInvoker.undoCommand();

        functionInvoker.executeCommand();
    }
}
