package com.demo.string;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * StringTest
 * @author gnl
 */

public class StringTest {

    @Test
    public void testJoiner() {
        String str = "123456789";

        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add(str);
        stringJoiner.add("qwe");
        // 123456789,qwe
        System.out.println(stringJoiner);

        // new StringJoiner(分隔符, 开头, 结尾);
        StringJoiner joiner = new StringJoiner(":", "{", "}");
        joiner.add("English").add("Math").add("physics");

        // {English:Math:physics}
        System.out.println(joiner);
    }

    @Test
    public void test02() {
        System.out.println(String.format("aaa: %d", 123));
    }

}
