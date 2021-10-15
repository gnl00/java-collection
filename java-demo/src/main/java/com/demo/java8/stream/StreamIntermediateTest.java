package com.demo.java8.stream;

import com.demo.bean.Employee;
import com.demo.bean.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * StreamIntermediateTest 测试stream中间操作
 *
 * @author gnl
 * @date 2021-02-06 11:47
 */

public class StreamIntermediateTest {

    /**
     * 1. 筛选与切片
     *   filter
     *   limit
     *   skip
     *   distinct
     */

    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // filter
        //stream.filter(e -> e.getSalary() > 2000.0).forEach(System.out::println);
        // limit(n) 只要前n个
        //stream.filter(e -> e.getSalary() > 2000.0).limit(3).forEach(System.out::println);
        // skip(n) 跳过前n个
        //stream.filter(e -> e.getSalary() > 2000.0).skip(3).forEach(System.out::println);

        employees.add(new Employee(1000, "user", 20, 30000.0));
        employees.add(new Employee(1000, "user", 20, 30000.0));
        employees.add(new Employee(1000, "user", 20, 30000.0));
        employees.add(new Employee(1000, "user", 20, 30000.0));

        stream.filter(e -> e.getSalary() > 2000.0).distinct().forEach(System.out::println);
    }

    /**
     * 2. 映射
     *  map
     */
    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
        employees.add(new Employee(1000, "user", 20, 30000.0));
        // map
        //employees.stream().map(e -> e.getName().toUpperCase()).forEach(System.out::println);
        employees.stream().map(Employee::getName).filter(name -> name.length() > 3 ).forEach(System.out::println);
    }

    // 3. 排序
    @Test
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();
        // Integer.compare() 顺序排序
        // -Integer.compare() 逆序排序
        employees.stream().sorted( (e1, e2) -> -Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
    }

}
