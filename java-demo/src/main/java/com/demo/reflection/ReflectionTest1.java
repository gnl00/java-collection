package com.demo.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TestReflection Java 反射测试类
 *
 * @author gnl
 */

public class ReflectionTest1 {

    public static void main(String[] args) {
        printClassInfo(ArrayList.class);
        System.out.println("===================");
        printClassInfo(String[].class);
        System.out.println("===================");
        printClassInfo(int.class);

    }

    static void printClassInfo(Class clazz) {
        System.out.println(String.format("className: %s", clazz.getName()));
        System.out.println(String.format("simpleName: %s", clazz.getSimpleName()));
        System.out.println(String.format("package: %s", clazz.getPackage()));
        System.out.println(String.format("is interface: %b", clazz.isInterface()));
        System.out.println(String.format("parent: %s", clazz.getSuperclass()));
        System.out.println(String.format("is array: %b", clazz.isArray()));
        Arrays.stream(clazz.getMethods()).forEach(System.out::println);
    }
}
