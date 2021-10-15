package com.demo.jingling;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Main
 *
 * @author gnl
 */

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = FileUtils.readLines(new File("E:\\error.log"));
        for (String s : strings) {
            System.out.println(s);
        }

    }
}
