package com.demo.command;

/**
 * DoCommand ConcreteCommand
 *
 * @author gnl
 */

public class DoCommand implements Command {

    private Receiver receiver;
    private String functionName;

    public DoCommand(Receiver receiver, String functionName) {
        this.receiver = receiver;
        this.functionName = functionName;
    }

    @Override
    public void execute() {
        receiver.execute(this.functionName);
    }

    @Override
    public void undo() {
        receiver.undo(this.functionName);
    }
}
