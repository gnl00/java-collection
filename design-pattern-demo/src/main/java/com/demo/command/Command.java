package com.demo.command;

/**
 * Command 接口
 * @author gnl
 */

public interface Command {

    /**
     * execute
     * @return void
     */
    void execute();

    /**
     * undo
     * @return void
     */
    void undo();

}
