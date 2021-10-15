package com.demo.collection.list;

import java.util.LinkedList;

/**
 * LinkedListTest
 * @author gnl
 */

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            final int temp = i;
            new Thread(() -> {

                list.add(temp + "");
                System.out.println(list);
            }).start();
        }
    }
}
