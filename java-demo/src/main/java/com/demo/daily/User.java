package com.demo.daily;

/**
 * Main
 *
 * @author gnl
 */

public class User extends Animal {

    private int age;

    public User() {
        System.out.println("non arg construct func");
    }

    public User(int age) {
        this.age = age;

        System.out.println("all args construct func");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

        System.out.println("setter");
    }

    static {
        System.out.println("static chunk");
    }

    {
        System.out.println("normal chunk");
    }



}
