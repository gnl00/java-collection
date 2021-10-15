package com.demo.classloader;

/**
 * ClassLoaderTest
 *
 * @author gnl
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);
        // sun.misc.Launcher$ExtClassLoader@677327b6
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
