package com.demo.state;

/**
 * Action
 *
 * @author gnl
 */

public class Account {

    private State state;
    private Double balance;

    private State gState = new GreenState(this);
    private State yState = new YellowState(this);
    private State rState = new RedState(this);

    public void deposit(Double money) {
        this.state.deposit(money);
    }

    public void withdraw(Double money) {
        this.state.withdraw(money);
    }

    public Account() {
        this.state = gState;
        this.balance = 0.0;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
        if (this.balance >= 0){
            this.state = gState;
        }
        if (this.balance >= -1000.0 && this.balance < 0){
            this.state = yState;
        }
        if (this.balance < -1000.0){
            this.state = rState;
        }

    }
}
