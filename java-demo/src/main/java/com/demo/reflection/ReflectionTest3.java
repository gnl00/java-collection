package com.demo.reflection;

import com.demo.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ReflectionTest3 访问 Class对象的构造方法
 *
 * @author gnl
 * @date 2021-03-19 21:47
 */

public class ReflectionTest3 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class clazz = User.class;
        showConstructorInfo(clazz);
    }

    static void showConstructorInfo(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取无参构造方法，并创建实例对象
        Object newInstance = clazz.getConstructor().newInstance();

        // 获取有参构造方法
        Constructor constructor = clazz.getConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Object instance = constructor.newInstance("zss", "123456");

        System.out.println(instance);
    }
}
