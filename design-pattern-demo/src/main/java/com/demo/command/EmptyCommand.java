package com.demo.command;

/**
 * EmptyCommand 空命令
 *
 * @author gnl
 */

public class EmptyCommand implements Command {

    @Override
    public void execute() {}

    @Override
    public void undo() {}
}
