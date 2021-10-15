package com.demo.java8.stream;

import com.demo.bean.Employee;
import com.demo.bean.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamApiTest 测试Stream的获取
 * java.util.stream
 *
 * @author gnl
 * @date 2021-02-04 16:35
 */

public class StreamGenerateTest {

    // 1. 通过集合创建Stream
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        /**
         * 获取一个并行流Stream
         * default Stream<E> stream() {
         *     return StreamSupport.stream(spliterator(), false);
         *  }
         */
        Stream<Employee> stream = employees.stream();
        stream.forEach(System.out::println);
        System.out.println("==========================");

        /**
         * 获取一个串行流Stream
         * default Stream<E> parallelStream() {
         *      return StreamSupport.stream(spliterator(), true);
         *  }
         */
        Stream<Employee> parallelStream = employees.parallelStream();
        parallelStream.forEach(System.out::println);
    }

    // 2. 通过数组获取Stream
    @Test
    public void test2() {
        int[] arr = new int[] {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);
    }

    // 3. 通过Stream.of()创建Stream
    @Test
    public void test3() {
        Stream<String> stringStream = Stream.of("aaa", "bbb", "ccc");
    }

    // 4. 创建无限流，用于特殊情况下创造数据
    @Test
    public void test4() {
        // 从0开始获取偶数，只取前10个数，输出
        Stream.iterate(0 ,t -> t + 2 ).limit(10).forEach(System.out::println);

        // 取10个随机数输出
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
