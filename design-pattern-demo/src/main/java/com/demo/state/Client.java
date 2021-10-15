package com.demo.state;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Account account = new Account();

        // green状态
        System.out.println("=== 当前状态 ===");
        System.out.println(account.getState());
        account.deposit(100.0);
        account.withdraw(50.0);
        System.out.println("=======================================");
        account.withdraw(60.0);
        System.out.println("=== 当前状态 ===");
        System.out.println(account.getState());
        System.out.println("=======================================");
        account.withdraw(2000.0);
        System.out.println("=== 当前状态 ===");
        System.out.println(account.getState());
        System.out.println("=======================================");
        account.withdraw(10.0);
        System.out.println("=== 当前状态 ===");
        System.out.println(account.getState());
        System.out.println("=======================================");
        account.deposit(4000.0);
        System.out.println("=== 当前状态 ===");
        System.out.println(account.getState());
    }
}
