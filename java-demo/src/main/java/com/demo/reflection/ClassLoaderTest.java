package com.demo.reflection;

import org.junit.Test;

/**
 * TestClassLoader 类加载器
 *
 * @author gnl
 * @date 2021-03-19 18:21
 */

public class ClassLoaderTest {

    @Test
    public void test1() {
        // Class clazz = Ref.class;
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        // Launcher$AppClassLoader
        System.out.println(classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        // Launcher$ExtClassLoader
        System.out.println(classLoader2);
        ClassLoader classLoader3 = classLoader2.getParent();
        // null
        System.out.println(classLoader3);
    }

}
