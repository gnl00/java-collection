package com.demo.puyuan;

import java.io.*;

/**
 * Main
 *
 * @author gnl
 */

public class Main {

    public static void main(String[] args) {

    }

    public static void letterCount() throws IOException {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File("D:\\test\\src\\test.txt")));

            String s = null;
            int sum = 0;

            while ((s = br.readLine()) != null) {
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    if (c != ' ') {
                        sum++;
                    }
                }
            }

            System.out.println(sum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                br.close();
            }

        }

    }

    public static void print9x9() {

        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }

    }

    public static void checkDir() {

        File file = new File("D:\\test\\src");
        String[] strings = file.list();

        for (String s : strings) {
            if (s.endsWith(".jpg")) {
                System.out.println(s);
            }
        }

    }

    public static void checkAllImg() throws IOException {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File("")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                br.close();
            }

        }

    }
}
