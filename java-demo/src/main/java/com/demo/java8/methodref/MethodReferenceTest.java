package com.demo.java8.methodref;

import com.demo.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * MethodReferenceTest
 *
 * @author gnl
 * @date 2021-02-03 21:22
 */

public class MethodReferenceTest {

    // 对象::实例方法
    @Test
    public void testConsumerMethodRefs() {
        PrintStream printStream = System.out;
        Consumer<String> consumer = printStream::println;
        consumer.accept("Consumer方法引用-对象::实例方法");
    }

    //对象::实例方法
    @Test
    public void testSupplierMethodRefs() {
        Employee employee = new Employee();
        employee.setName("Supplier方法引用-对象::实例方法");
        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());
    }

    //类::静态方法
    @Test
    public void testComparatorMethodRefs() {
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(1, 2));
        System.out.println("=======================================");
        Comparator<Integer> comparator2 = Integer::compare ;
        System.out.println(comparator2.compare(2, 2));

    }

    //类::静态方法
    // Function -> R apply(T t);
    // Math -> R round(T t);
    @Test
    public void testFunctionMethodRefs() {
        Function<Double, Long> function = Math::round;
        Long apply = function.apply(12.6);
        System.out.println(apply);
    }

    //类::实例方法
    @Test
    public void test1() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("aaa", "bbb"));
        System.out.println("================================");
        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("abc", "def"));

    }

    //BiPredicate<T, R> -> boolean test(T, R)
    //String -> boolean equals(T)
    //类::实例方法
    @Test
    public void test2() {
        BiPredicate<String, String> predicate = (a, b) -> a.equals(b);
        System.out.println(predicate.test("aaa", "123"));
        System.out.println("================================");
        BiPredicate<String, String> predicate1 = String::equals;
        System.out.println(predicate1.test("123", "123"));
    }

    //Function -> R apply(T t)
    //Employee -> String getName()
    //类::实例方法
    @Test
    public void test3() {
        Employee employee = new Employee(1, "aaa", 10, 1000.0);
        Function<Employee, String> function = e -> e.getName();
        System.out.println(function.apply(employee));
        System.out.println("================================");
        Function<Employee, String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));
    }

    //构造器引用
    @Test
    public void test4() {
        Supplier<Employee> supplier = Employee::new;
        supplier.get();
    }

    //数组引用
    @Test
    public void test5() {
        Function<Integer, String[]> function = String[]::new;
        System.out.println(Arrays.asList(function.apply(5)));
    }

}
