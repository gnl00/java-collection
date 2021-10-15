package com.demo.oop;

/**
 * InnerClassTest
 *
 * @author gnl
 */

public class InnerClassTest {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MyClass.NormalInnerClass inner = myClass.new NormalInnerClass();
    }

}

class MyClass {
    public String name;
    private String password;

    private static class StaticInnerClass {
        private static String staticInnerPW;
        private String InnerPW;
    }

    public class NormalInnerClass {

        private String normalInnerPW;

    }

    public void showPW() {

        System.out.println(this.password);
        System.out.println(StaticInnerClass.staticInnerPW);

        StaticInnerClass aClass = new StaticInnerClass();
        System.out.println(aClass.InnerPW);

    }
}

