package com.demo.io;

import com.demo.bean.User;

import java.io.*;

/**
 * IOTest
 *
 * @author gnl
 */

public class IOTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("12333333");

        File file = new File("java-demo/src/main/resources/io-write-test.txt");
        FileWriter writer = null;
        try {
            /**
             * @param1 file 写出到的文件
             * @param2 写出模式为覆盖或是追加，默认false为覆盖，true为追加
             * @return void
             */
            writer = new FileWriter(file);
            writer.write(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
