package com.demo.java8.stream;

import com.demo.bean.Employee;
import com.demo.bean.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StreamTerminateOperationTest 测试Stream终止操作
 *
 * @author gnl
 * @date 2021-02-06 12:48
 */

public class StreamTerminateOperationTest {

    // 匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        boolean anyMatch = employees.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(anyMatch);
        boolean noneMatch = employees.stream().noneMatch(e -> e.getAge() > 18);
        System.out.println(noneMatch);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        Optional<Employee> pAny = employees.parallelStream().findAny();
        System.out.println(pAny);

        long count = employees.stream().filter(e -> e.getAge() > 20).count();
        System.out.println(count);

        Optional<Double> max = employees.stream()
                .map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(max);

        // 返回工资最低的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

    }

    // 归约
    @Test
    public void test2() {
        // 求1-10和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduceSum = list.stream().reduce(0, Integer::sum);
        System.out.println(reduceSum);

        // 求员工工资总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> empSalarySum = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(empSalarySum);
    }

    // 收集
    @Test
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 3000.0).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
    }

}
