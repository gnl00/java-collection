package com.demo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-02-04 10:23
 */

public class EmployeeData {

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100, "aaa", 10, 1000.0));
        employees.add(new Employee(200, "bbb", 20, 2000.0));
        employees.add(new Employee(300, "ccc", 30, 3000.0));
        employees.add(new Employee(400, "ddd", 40, 4000.0));
        employees.add(new Employee(500, "eee", 50, 5000.0));
        employees.add(new Employee(600, "fff", 60, 6000.0));
        return employees;
    }

}
