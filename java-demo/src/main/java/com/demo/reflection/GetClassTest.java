package com.demo.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * GetClassTest 获取Class对象的不同方式
 * @author gnL
 */

public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        // 加载配置文件

        // 方式1
        Properties properties = new Properties();
        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        // reflectConfig.properties放在与src同级别或者在resources内
        InputStream is = classLoader.getResourceAsStream("reflectConfig.properties");
        properties.load(is);
        String className = properties.getProperty("className");
        System.out.println(className);

        // 方式2
//        ResourceBundle bundle = ResourceBundle.getBundle("reflectConfig");
//        String className = bundle.getString("className");
//        System.out.println(className);
//        Enumeration<String> bundleKeys = bundle.getKeys();
//        while (bundleKeys.hasMoreElements()) {
//            System.out.println(bundleKeys.nextElement());
//        }

        // 1. Class.forName 多用于配合配置文件。将全类名定义在配置文件中，读取配置文件，加载类，获取Class
        Class clazz = Class.forName(className);


        // 2. 类名.class 多用于方法中参数传递
        Class clazz2 = GetClassTest.class;

        // 3. 多用于对象 获取对象字节码
        GetClassTest getClassTest = new GetClassTest();
        Class<? extends GetClassTest> clazz3 = getClassTest.getClass();

        // true
        System.out.println(clazz == clazz2);
        // true
        System.out.println(clazz2 == clazz3);
        // true
        System.out.println(clazz == clazz3);
    }
}
