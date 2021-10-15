package com.demo.state;

/**
 * State
 * @author gnl
 */

public interface State {

    /**
     * deposit 存款
     * @param money
     * @return void
     * @author gnl
     */
    public void deposit(Double money);

    /**
     * withdraw 取款
     * @param money
     * @return void
     * @author gnl
     */
    public void withdraw(Double money);

}
