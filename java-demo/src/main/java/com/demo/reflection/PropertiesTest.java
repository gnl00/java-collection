package com.demo.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Java读取properties
 *
 * @author gnl
 * @date 2021-03-19 20:36
 */

public class PropertiesTest {
    
    @Test
    public void test1() {
        ResourceBundle bundle = ResourceBundle.getBundle("reflectConfig");
        String className = bundle.getString("className");
        System.out.println(className);

        Enumeration<String> bundleKeys = bundle.getKeys();
        while (bundleKeys.hasMoreElements()) {
            System.out.println(bundleKeys.nextElement());
        }
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        // reflectConfig.properties放在与src同级别或者在resources内
        InputStream is = classLoader.getResourceAsStream("reflectConfig.properties");
        properties.load(is);
        String className = properties.getProperty("className");
        System.out.println(className);
    }
    
}
