package com.demo.huawei;

import java.util.*;

import java.util.stream.Collectors;

/**
 * DailyTest
 *
 * @author gnl
 */

public class DailyTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

    }

    /**
     * 15.求int型正整数在内存中存储时1的个数
     */
    public static void count1(int n) {
        int i = Integer.bitCount(n);
        System.out.println(i);

    }


    /**
     * 14.字符串排序
     */
    public static void stringSorted() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String s = in.nextLine().trim();
            if (!"".equals(s) && null != s) {
                list.add(s);
            }
        }

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            String currentKey = list.get(i);
            if (map.containsKey(currentKey)) {
                map.put(currentKey, map.get(currentKey) + 1);
            } else {
                map.put(currentKey, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                System.out.println(entry.getKey());
            }

        }

    }

    /** 
     * 13.句子逆序
     */
    public static void sentenceReversal(String s) {

        String revers = "";

        String[] arr = s.split(" ");

        int i = arr.length - 1;
        while (i >= 0) {
            String current = arr[i];
            boolean legalFlag = true;
            for (int j = 0; j < current.length(); j++) {
                if (!legalCharacter(s.charAt(j))) {
                    legalFlag = false;
                }
            }
            if (legalFlag && i != 0) {
                revers += current + " ";
            } else {
                revers += current;
            }

            i--;
        }

        System.out.println(revers);

    }

    // 是空格或者字母
    public static boolean legalCharacter(char c) {
        int n = (int)c;
        return n == 32 || 65 <= n && n <= 90 || 97 <= n && n <= 122;

    }

    /**
     * 12.字符串反转
     */
    public static void stringReverse(String s) {
        String sub = "";
        int i = s.length() - 1;
        while (i >= 0) {
            if (isLowercase(s.charAt(i))) {
                sub += s.charAt(i) + "";
                if (i == 0) {
                    System.out.println(sub);
                }

            } else {
                break;
            }
            i--;
        }

    }

    // 是否是小写字母
    public static boolean isLowercase(char ch) {
        return 97 <= (int) ch && (int) ch <= 122;
    }

    /**
     * 11.数字颠倒
     */
    public static void numReverse(int n) {
        String s = n + "";

        int i = s.length() - 1;
        String sub = "";
        while (i >= 0) {
            sub += s.charAt(i) + "";
            i--;
        }

        System.out.println(sub);

    }

    /**
     * 10.字符个数统计
     */
    public static void characterCount(String s) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int counter = 0;
        for (Character c : set) {
            if (0 <= (int) c && (int) c <= 127) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    /**
     * 9.提取不重复的整数
     */
    public static void getNoRepeatedInteger(String s) {

        String sub = "";
        int i = s.length() - 1;

        while (i >= 0) {
            if (sub.indexOf(s.charAt(i) + "") == -1) {
                sub = sub + s.charAt(i);
            }
            i--;
        }

        System.out.println(sub);

    }

    /**
     * 8.合并表记录
     */
    public static void mergeTableRecords() {

        Map<Integer, Integer> integerMap = new TreeMap<>();

        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        for (int i = 0; i < Integer.valueOf(nextLine); i++) {
            String[] arr = in.nextLine().trim().split(" ");

            int currentKey = Integer.valueOf(arr[0]);
            int currentVal = Integer.valueOf(arr[1]);

            if (integerMap.containsKey(currentKey)) {
                integerMap.put(currentKey, integerMap.get(currentKey) + currentVal);
            } else {
                integerMap.put(currentKey, currentVal);
            }
        }

        for (Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 7.取近似值
     */
    public static void takeApproximate(float f) {

        int integer = (int) f;
        if (f - integer >= 0.5) {
            System.out.println(integer + 1);
        } else {
            System.out.println(integer);
        }

    }

    /**
     * 6.n的质因子
     */
    public static void qualityFactor(int n) {

        List<Integer> list = new ArrayList<>();

        // 找出n所有因子
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        // 找出因子中的质数


        System.out.println(list);
    }

    /**
     * 5.16进制转10进制
     */
    public static void hexTransform() {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (in.hasNext()) {
            list.add(in.nextLine().trim());
        }

        for (String s : list) {
            if (s.startsWith("0x")) {
                s = s.substring(2, s.length());
            }
            System.out.println(Integer.parseInt(s, 16));
        }

    }

    /**
     * 4.字符串每8位分割
     */
    public static void stringSplit() {
        Scanner in = new Scanner(System.in);
        List<String> strList = new ArrayList<>();

        while (in.hasNext()) {
            String s = in.nextLine().trim();
            if (!"".equals(s) && null != s) {
                strList.add(s);
            }
        }

        for (String s : strList) {
            if (s.length() <= 8) {
                int len = 8 - s.length();
                for (int i = 0; i < len; i++) {
                    s += "0";
                }
            } else if (s.length() > 8) {
                int i = 0;
                while (i + 8 <= s.length()) {
                    System.out.println(s.substring(i, i + 8));

                    i += 8;
                }


                if (i + 8 > s.length()) {

                    int len = s.length() - i;
                    s = s.substring(i, s.length()).trim();

                    if (!"".equals(s) && s != null) {
                        for (int j = 0; j < 8 - len; j++) {
                            s += "0";
                        }
                    }
                }

            }

            if (!"".equals(s) && s != null) {
                System.out.println(s);
            }
        }
    }

    /**
     * 3.明明的随机数
     */
    public static void MMRandom() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }

            list = list.stream().sorted().distinct().collect(Collectors.toList());

            for (Integer i : list) {
                System.out.println(i);
            }

        }

    }

    /**
     * 2.计算某字母出现次数
     */
    public static int letterCount(String s, String letter) {

        if (s.indexOf(letter) == -1) {
            return 0;
        } else {

            String sub = "";
            int i = 0, counter = 0;
            while (i < s.length()) {
                if (letter.toLowerCase().equals((s.charAt(i) + "").toLowerCase())) {
                    counter++;
                }
                i++;
            }
            return counter;
        }

    }


    /**
     * 1.字符串最后一个单词的长度
     */
    public static int lastWordLength(String s) {

        String str = "";

        int i = s.length() - 1;
        while (i >= 0) {

            if (' ' == s.charAt(i)) {
                break;
            }
            str = s.charAt(i) + str;

            i--;
        }

        return str.length();
    }
}
