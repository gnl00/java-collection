package com.demo.dongfang;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Solution
 * [98.0,99.0,80.0,75.0,60.0]
 * @author gnl
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String originStr = in.nextLine();

        String[] split = originStr.substring(1, originStr.length() - 1).split(",");

        // 转成 Float
        Float[] scores = new Float[split.length];
        int index = 0;

        for (String s : split) {
            scores[index++] = Float.valueOf(s);
        }

        List<Float> floats = Arrays.asList(scores).stream().sorted(Float::compareTo).collect(Collectors.toList());

        // 获取真正操作的float数组
        float[] finalScores = new float[scores.length-2];
        int finalIndex = 0;
        for (int i = 1; i < floats.size() - 1; i++) {
            finalScores[finalIndex++] = floats.get(i);
        }

        Solution s = new Solution();
        float res = s.calAverageScore(finalScores);
        System.out.println(res);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算平均得分
     * @param scores float浮点型一维数组 分数
     * @return float浮点型
     */
    public float calAverageScore (float[] scores) {
        // write code here

        Float[] f = new Float[scores.length];
        int index = 0;
        for (float score : scores) {
            f[index++] = score;
        }

        List<Float> floats = Arrays.asList(f).stream().sorted(Float::compareTo).collect(Collectors.toList());

        float sum = 0;
        for (float score : scores) {
            sum += score;
        }
        float res = sum/scores.length;
        String formatRes = String.format("%.2f", res);

        return Float.valueOf(formatRes);
    }
}
