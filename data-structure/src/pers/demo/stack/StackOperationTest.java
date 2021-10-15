package pers.demo.stack;

import java.util.Stack;

/**
 * 关于栈的运算操作
 *
 * @author gnl
 * @date 2021-04-20 14:09
 */

public class StackOperationTest {

    public static void main(String[] args) throws Exception {
        String str = "1+2*3-4/5";

        infixToSuffix(str);
    }

    /**
     * infixToSuffix 中缀转后缀
     * @author gnl
     */
    public static void infixToSuffix(String infix) throws Exception {

        char[] chars = infix.toCharArray();

        // 符号栈
        Stack<String> opStack = new Stack<>();

        StringBuilder suffix = new StringBuilder();

        for (char ch : chars) {
            if (isOperator(ch+"")) {

                if (opStack.isEmpty() || calcPriority(ch+"") > calcPriority(opStack.peek())) {
                    opStack.push(ch+"");
                } else {
                    while ( !opStack.isEmpty() && calcPriority(ch+"") <= calcPriority(opStack.peek()) ) {
                        suffix.append(opStack.pop());
                    }
                    opStack.push(ch+"");
                }

            } else {
                suffix.append(ch);
            }
        }

        while (opStack.size() !=0 ) {
            suffix.append(opStack.pop());
        }

        System.out.println(suffix);

    }

    /**
     * 判断当前字符是否为运算符
     * @param str
     * @author gnl
     */
    public static boolean isOperator(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "(":
            case ")":
                return true;
            default:
                return false;
        }
    }

    /**
     * 判断运算符优先级
     * @param operator
     * @return int
     * @author gnl
     */
    public static int calcPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            case "(":
            case ")":
                return 2;
            default:
                return -1;
        }
    }

    /**
     * 进行运算操作
     * @return int
     * @author gnl
     */
    public static int doOperation(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                if (b == 0) {
                    System.out.println("被除数为0");
                    break;
                }
                return a/b;
            default:
                break;
        }
        throw new Exception("运算出错");
    }
}
