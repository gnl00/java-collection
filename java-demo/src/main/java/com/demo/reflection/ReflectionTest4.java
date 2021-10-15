package com.demo.reflection;

import com.demo.bean.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ReflectionTest4 访问 Class对象的方法
 *
 * @author gnl
 * @date 2021-03-19 22:09
 */

public class ReflectionTest4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = User.class;
        invokeMethod(clazz);
    }

    static void invokeMethod(Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object o = clazz.newInstance();

         Method[] declaredMethods = clazz.getDeclaredMethods();
         Arrays.stream(declaredMethods).forEach(System.out::println);

        System.out.println("**************************************");

        // 有参方法，getMethod(方法名, 方法参数)
        Method publicMsg = clazz.getMethod("publicMsg", String.class);

        // 执行有参方法 invoke(实例对象，方法参数值)
        // res 方法返回值
        Object res = publicMsg.invoke(o, "aaa");
        System.out.println(String.format("result: %s", res));

        // 无参方法，getDeclaredMethod(方法名)
        Method privateMsg = clazz.getDeclaredMethod("privateMsg");
        // 私有方法需要忽略安全检查
        privateMsg.setAccessible(true);

        // 执行无参方法 invoke(实例对象)
        Object privateResult = privateMsg.invoke(o);
        System.out.println(privateResult);
    }
}
