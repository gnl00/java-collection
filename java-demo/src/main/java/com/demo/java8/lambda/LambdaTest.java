package com.demo.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * LambdaTest
 *
 * @author gnl
 * @date 2021-02-03 13:33
 */

public class LambdaTest {

    @Test
    public void testRunnable() {
        Runnable runnable = () -> {
            System.out.println("runnable");
        };
        runnable.run();
    }

    @Test
    public void testLambda() {

        // 常规写法
        Comparator<Integer> normalComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(normalComparator.compare(4, 5));

        /**
         * Lambda 表达式写法
         *  (a, b) -> Integer.compare(a, b)
         *  左边 => lambda形参列表，即接口中抽象方法的形参列表
         *  右边 => lambda体，即重写的方法体
         * @author gnl
         * @date 2021/2/3 13:38
         */
        Comparator<Integer> lambdaComparator = (a, b) -> Integer.compare(a, b);
        System.out.println(lambdaComparator.compare(1, 2));

        /**
         * 方法引用写法
         *
         * @author gnl
         * @date 2021/2/3 13:40
         */
        Comparator<Integer> methodReferenceComparator = Integer :: compare;
        int res = methodReferenceComparator.compare(2, 3);
        System.out.println(res);

    }

    /**
     * 一个参数,无返回值
     */
    @Test
    public void oneArg_noRet() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("LambdaTest.noArg_noRet");
    }

    /**
     * 两个或以上参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void argsAndRet() {
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        System.out.println(comparator.compare(3, 2));
    }

    @Test
    public void testConsumer() {
     Consumer<String> consumer = s -> System.out.println(s);
     consumer.accept("消费者型函数式接口");
    }

    @Test
    public void testConsumer2() {
        shopping(400.00, money -> {
            System.out.println("购物消费: " + money );
        });
    }

    static void shopping(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testSupplier() {
        Supplier<String> supplier = () -> "供给型函数式接口";
        System.out.println(supplier.get());
    }

    @Test
    public void testFunction() {
        Function<String, String> function = (s) -> {
            String pw = "123";
            if (pw.equals(s)){
                return "密码正确";
            }
            return "密码不正确";
        };
        String res = function.apply("456");
        System.out.println(res);
    }
    
    @Test
    public void testPredicate() {
        Predicate<String> predicate = (s) -> s.equals("aaa");
        System.out.println(predicate.test("abc"));
    }

    @Test
    public void testPredicate2() {
        List<String> resList = filterString(Arrays.asList("a", "bb", "cc", "d"), s -> s.length() < 2);
        System.out.println(resList);
    }

    static List<String> filterString(List<String> strings, Predicate<String> predicate) {
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            if (predicate.test(s)){
                list.add(s);
            }
        }
        return list;
    }

    @Test
    public void testFilter() {
        List<String> strings = Arrays.asList("a", "bb", "cc", "d");
        strings.stream().filter(s -> s.length() > 2).forEach(System.out::println);
    }

}
