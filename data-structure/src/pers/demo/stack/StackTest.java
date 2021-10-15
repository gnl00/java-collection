package pers.demo.stack;

import java.util.Stack;

/**
 * StackTest 栈的应用
 *
 * @author gnl
 */

public class StackTest {
    public static void main(String[] args) {
        String infix = "1+2*3-4/5";

        String suffix = infixToSuffix(infix);
        System.out.println(suffix);

//        char e = 'a';
//        System.out.println(((int) e));

    }

    /**
     * infixToSuffix 中缀转后缀
     *
     * @param str
     * @return java.lang.String
     * @author gnl
     */
    public static String infixToSuffix(String str) {
        char[] chars = str.toCharArray();
        StringBuilder suffix = new StringBuilder();

        // 符号栈，不需要数字栈，只需要将数字拼接到字符串中即可
        Stack<Character> opStack = new Stack<>();

        for (char c : chars) {

            if (!isNumber(c)) {

                // 直接push进符号栈的情况有： ① 符号栈为空；② 当前操作符优先级大于符号栈顶优先级
                if ( opStack.isEmpty() || getPriority(c) > getPriority(opStack.peek()) ) {
                    opStack.push(c);
                } else {

                    // 符号栈非空，并且当前操作符优先级小于等于栈顶操作符优先级

                    // 处理符号栈中的操作符
                    while (opStack.size() > 0 && getPriority(c) <= getPriority(opStack.peek()) ) {
                        suffix.append(opStack.pop());
                    }

                    // 栈中的操作符处理完毕，再将当前操作符入栈
                    opStack.push(c);

                }

            } else {
                suffix.append(c);
            }

        }

        while (!opStack.isEmpty()) {
            suffix.append(opStack.pop());
        }

        return suffix.toString();

    }

    /**
     * isNumber 判断是否是数字 ASCII码区间为48-57
     *
     * @param c
     * @return boolean
     * @author gnl
     */
    public static boolean isNumber(char c) {
        return ( (int)c >= 48 && (int)c <= 57 );
    }

    /**
     * getPriority 获取运算符优先级
     *
     * @param c
     * @return int
     * @author gnl
     */
    public static int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }

    }

    /**
     * doOperation 进行运算
     *
     * @param a
     * @param b
     * @param c
     * @return int
     * @author gnl
     */
    public static int doOperation(int a, int b, char c) {
        return -1;
    }


}
