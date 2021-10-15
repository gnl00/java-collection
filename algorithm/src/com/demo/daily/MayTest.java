package com.demo.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * MayTest 5月练习
 *
 * @author gnl
 */

public class MayTest {
    public static void main(String[] args) {

        int[] height = {1,2,1};
        System.out.println(new MayDay04().maxArea(height));

    }

    // 图深度遍历
    public static void graphDepth() {}

    // 图广度遍历
    public static void graphWidth() {}

}

class MayDay04 {

    /**
     * 盛最多水的容器
     */
    public int maxArea(int[] height) {

        int leftMax = 0, rightMax = 0;

        for (int i = 0; i < height.length / 2; i++) {
            int j = i + 1;
            while (j < height.length) {
                int tmpArea = 0;
                tmpArea = height[i] > height[j] ? height[j] * (j-i) : height[i] * (j-i);
                leftMax  = leftMax < tmpArea ? tmpArea : leftMax;
                j++;
            }
        }

        for (int i = height.length / 2; i < height.length; i++) {
            int j = i + 1;
            while (j < height.length) {
                int tmpArea = 0;
                tmpArea = height[i] > height[j] ? height[j] * (j-i) : height[i] * (j-i);
                rightMax  = rightMax < tmpArea ? tmpArea : rightMax;
                j++;
            }
        }

        int finalMax = leftMax > rightMax ? leftMax : rightMax;

        return finalMax;
    }

    /**
     * 字符串转换整数 (atoi)
     */
    public int myAtoi(String s) {

        s = s.trim();

        if (s.length() == 0 || s.isEmpty()) {
            return 0;
        }

        if (! isNum(s.charAt(0)) && '+' != s.charAt(0) && '-' != s.charAt(0)) {
            return 0;
        } else {

            String sub = "";

            String symbol = "";

            if ('+' == s.charAt(0) || '-' == s.charAt(0)) {
                if ('-' == s.charAt(0)) {
                    symbol = "-";
                }

                s = s.substring(1);
            }

            int i = 0;
            while (i < s.length()) {
                if (isNum(s.charAt(i))) {
                    sub += s.charAt(i);
                } else {
                    break;
                }
                i++;
            }

            while (sub.startsWith("0")) {
                sub = sub.substring(1);
            }

            String maxInteger = Integer.MAX_VALUE + "";

            if (!"".equals(sub)) {

                if (sub.length() < maxInteger.length()) {
                    if ("-".equals(symbol)) {
                        sub = symbol + sub;
                    }
                    return Integer.valueOf(sub);
                } else if (sub.length() > maxInteger.length()){
                    if ("-".equals(symbol)) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {

                    if ("-".equals(symbol)) {
                        sub = symbol + sub;
                    }

                    Long res = Long.valueOf(sub);

                    if (res > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (res < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.valueOf(sub);
                    }
                }
            } else {
                return 0;
            }

        }
    }

    // 48-57
    public boolean isNum(char ch) {
        return 48 <= (int)ch && (int)ch <= 57;
    }

}

class MayDay03 {

    /**
     * Z 字形变换
     */
    public String convert(String s, int numRows) {

        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        String sub = "";

        char [][] a = new char[numRows][s.length() / 2 + 1];

        int i = 0, j = 0, k = 0;

        while (i < s.length()) {
            if (j == 0 && i < s.length()) {
                for (int l = 0; l < numRows - 1; l++) {
                    if (i < s.length()) {
                        a[j++][k] = s.charAt(i++);
                    }
                }
            }
            if (j == numRows - 1 && i < s.length()) {
                for (int l = 0; l < numRows - 1; l++) {
                    if (i < s.length()) {
                        a[j--][k++] = s.charAt(i++);
                    }
                }
            }

        }

        for (int l = 0; l < a.length; l++) {
            for (int m = 0; m < a[l].length; m++) {
                if (a[l][m] != '\u0000') {
                    sub += a[l][m];
                }
            }
        }

        return sub;
    }

    // 全排列
    public void func(String s) {

        String sub = "";

        for (int i = 0; i < s.length(); i++) {
            sub = s.charAt(i) + "";
            int count = 1;
            while (count < s.length()) {
                int j = i + count;

                while (sub.length() < s.length()) {
                    j = j % s.length();
                    if (sub.indexOf(s.charAt(j)) == -1) {
                        sub += s.charAt(j);
                    }
                    j++;
                }
                System.out.println(sub);
                sub = s.charAt(i) + "";

                count++;
            }

        }

    }

}

class MayDay02 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串
     */
    public String longestPalindrome(String s) {

        String sub = "";
        String maxSub = "";

        int i = 0, j = i;

        while (i < s.length() && j <= s.length() && s.length() - i > maxSub.length()) {

            sub = s.substring(i, j);

            if (isPalindrome(sub)) {
                maxSub = maxSub.length() < sub.length() ? sub : maxSub;
            }

            j++;

            if (j > s.length() && i < s.length()) {
                i++;
                j = i;
                sub = "";
            }

        }
        return maxSub;
    }

    // 判断传入的字符串是否是回文
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while ( j >= i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * 请你找出其中不含有重复字符的 最长子串 的长度
     */
    public int lengthOfLongestSubstring(String s) {

        String subStr = "";

        int i = 0, j = i;
        int maxLen = 0;
        while (i < s.length() && j < s.length() && s.length() - i > maxLen) {
            if (subStr.indexOf(s.charAt(j)) != -1) {
                i++;
                j = i;
                subStr = "";
            } else {
                subStr += s.charAt(j);
                j++;
            }
            maxLen = subStr.length() > maxLen ? subStr.length() : maxLen;
        }

        return maxLen;
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> list = new ArrayList<>();
        int left = 0;
        int res = 0;

        while (l1 != null && l2 != null) {

            if (left == 0) {
                res = l1.val + l2.val;
            } else {
                res = l1.val + l2.val + left;
                left = 0;
            }

            if (res < 10) {
                list.add(res);
            } else {
                left = 1;
                list.add(res - 10);
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (left != 0) {
                res = l1.val + left;
                left = 0;
                if (res < 10) {
                    list.add(res);
                } else {
                    left = 1;
                    list.add(res - 10);
                }

            } else {
                list.add(l1.val);
            }

            l1 = l1.next;
        }

        while (l2 != null) {

            if (left != 0) {
                res = l2.val + left;
                left = 0;

                if (res < 10) {
                    list.add(res);
                } else {
                    left = 1;
                    list.add(res - 10);
                }

            } else {
                list.add(l2.val);
            }

            l2 = l2.next;
        }

        if (left != 0) {
            list.add(left);
        }

        System.out.println(list);

        ListNode head = new ListNode(list.get(0));
        ListNode tmp = head;
        int i = 1;
        while ( i < list.size() ) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
            i++;
        }

        System.out.println(head);

        return head;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class MayDay01 {

    // 汉明码距离
    public int totalHammingDistance(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return sum;
    }
}
