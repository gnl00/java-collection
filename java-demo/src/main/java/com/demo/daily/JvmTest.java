package com.demo.daily;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * JvmTest
 *
 * @author gnl
 */

public class JvmTest {
    public static void main(String[] args) {

        String str = "str123";
        PhantomReference<String> phantomReference = new PhantomReference<>(str, new ReferenceQueue<>());

        System.out.println("hello, jvm...");

    }

    static {
        System.out.println("im static chunk");
    }
}
