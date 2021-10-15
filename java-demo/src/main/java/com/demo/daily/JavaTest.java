package com.demo.daily;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.*;

/**
 * JavaTest
 *
 * @author gnl
 */

public class JavaTest {

    @Test
    public void test1() {
        BigDecimal bd = new BigDecimal(123.456);
        System.out.println(bd.multiply(bd));
    }

    @Test
    public void test2() {
        Assert.assertEquals("asd", "asd");
    }

    @Test
    public void test3() {
        System.out.println(E);
        System.out.println(sin(60));
    }

    @Test
    public void test4() {
        double a = 25/2;
        System.out.println(a);
    }

    @Test
    public void test5() {

        int random = new Random().nextInt(10);

        System.out.println(random);
    }

    @Test
    public void test6() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test7() {
        String[][] arr = {
                {"a", "b", "c"},
                {"a", "b", "c"},
                {"a", "b", "c"},
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {

            }
        }

    }

    @Test
    public void test8() {

        int[] a = {1,3,2,4,6,5,8,7};
        int[] b = {3,4,5,7,100,200};


    }

    @Test
    public void test9() {

        double d = 0.3654;

        System.out.println();
    }

    @Test
    public void test10() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        User user = new User(1);
        System.out.println();

        User user1 = User.class.newInstance();
        System.out.println();

        User user2 = User.class.getConstructor().newInstance();


    }

    @Test
    public void test11() {
        List<String> lists = new ArrayList<>();
        lists.add(null);
        lists.add(null);
        lists.add(null);
        lists.add("asd");

        List<String> linkedList = new LinkedList<>();
        linkedList.add(null);

        List<String> vector = new Vector<>();
        vector.add(null);
    }

}
