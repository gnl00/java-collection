package com.demo.oop;

import java.util.PrimitiveIterator;

/**
 * OOPTest 面向对象测试
 *
 * @author gnl
 */

public class OOPTest {
    public static void main(String[] args) {
        Son son = new Son();

        son.invoked();
    }
}

interface CustomInterface {
    default void add() {
        System.out.println("CustomInterface");
    }
}

interface MyInterface {

    int num = 0;

    default void add() {
        System.out.println("MyInterface");
    }
}

abstract class Father {

    int num = 0;

    public void add() {
        System.out.println("Father");
    }
}

class Son extends Father implements MyInterface, CustomInterface {
    public void invoked() {
        add();
        System.out.println();
    }
}


