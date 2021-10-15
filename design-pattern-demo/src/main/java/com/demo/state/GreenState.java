package com.demo.state;

/**
 * ConcreteState
 *
 * @author gnl
 */

public class GreenState implements State {

    private Account account;

    public GreenState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(Double money) {
        account.setBalance(account.getBalance() + money);
        System.out.println("存款: " + money + "\t余额: " + account.getBalance());
    }

    @Override
    public void withdraw(Double money) {
        account.setBalance(account.getBalance() - money);
        System.out.println("取款: " + money + "\t余额: " + account.getBalance());
    }
}
