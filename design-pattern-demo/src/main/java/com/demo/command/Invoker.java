package com.demo.command;

/**
 * Invoker
 *
 * @author gnl
 */

public class Invoker {

    private Command command;

    private Command undoCommand;

    public Invoker() {
        this.command = new EmptyCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setUndoCommand(Command undoCommand) {
        this.undoCommand = undoCommand;
    }

    public void executeCommand() {
        this.command.execute();
    }

    public void undoCommand() {
        this.undoCommand.undo();
    }
}
