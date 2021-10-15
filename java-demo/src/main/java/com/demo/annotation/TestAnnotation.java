package com.demo.annotation;

/**
 * TestAnnotation Java 注解测试类
 * @author gnl
 */

@TokenRequired(required = true)
public class TestAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {

        boolean classRequired = TestAnnotation.class.getAnnotation(TokenRequired.class).required();
        System.out.println("classRequired " + classRequired);

        boolean methodRequired = TestAnnotation.class.getMethod("hello", null).getAnnotation(TokenRequired.class).required();
        System.out.println("methodRequired " + methodRequired);

    }

    @TokenRequired(required = false)
    public String hello() {
        return null;
    }

}
