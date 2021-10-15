package com.demo.bean;

import java.io.Serializable;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-03-18 20:13
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password;
    public String gender;
    String skin;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", skin='" + skin + '\'' +
                '}';
    }

    public String publicMsg(String msg) {
        System.out.println("User publicMsg");
        return msg;
    }

    private int privateMsg() {
        System.out.println("User privateMsg");
        return 10;
    }
}
