package com.demo.daily;

/**
 * Animal
 *
 * @author gnl
 */

public class Animal {

    public Animal() {
        System.out.println("parent construct func");
    }

    static {
        System.out.println("parent static chunk");
    }

    {
        System.out.println("parent normal chunk");
    }

}
