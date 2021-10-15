package com.demo.jingling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtils
 *
 * @author gnl
 * @date 2021-05-18 10:37
 */

public class FileUtils {

    public static List<String> readLines(File file) throws IOException {
        BufferedReader br = null;
        List<String> strings = null;

        try {
            br = new BufferedReader(new FileReader(file));
            strings = new ArrayList<>();

            int count = 0;
            while (count < 10) {
                String s = br.readLine();
                if (s.indexOf("ERROR") != -1) {
                    strings.add(s);
                    count++;
                }
            }

            return strings;
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            br.close();
        }
    }

}
