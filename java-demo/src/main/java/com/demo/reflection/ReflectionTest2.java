package com.demo.reflection;

import com.demo.bean.User;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * ReflectionTest2 访问 Class对象的成员变量信息
 *
 * @author gnl
 * @date 2021-03-19 21:10
 */

public class ReflectionTest2 {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class userClazz = User.class;
        showFiledInfo(userClazz);
    }
    
    /** 
     * showFiledInfo 获取成员变量信息
     */
    static void showFiledInfo(Class clazz) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 获取public修饰的成员变量信息
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println("****************************");
        // 忽略修饰符 获取到类的所有成员变量信息
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);

        // 1. 为成员变量赋值
        Field gender = clazz.getField("gender");
        User user = new User();
        gender.set(user, "male");

        // 为非public修饰的成员变量赋值
        Field username = clazz.getDeclaredField("username");
        // 操作非public修饰的变量前，需要忽略访问修饰符的安全检查
        // 此做法也被称为【暴力反射】
        username.setAccessible(true);
        username.set(user, "Sb");

        // 2. 获取字段值
        Object obj = username.get(user);
        System.out.println(obj);

        System.out.println(user);
    }
}
