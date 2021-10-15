package com.demo.compare;

import java.util.Arrays;

/**
 * ComparableTest
 *
 * @author gnl
 */

public class ComparableTest {
    public static void main(String[] args) {

        CompareBean[] arr = new CompareBean[3];

        arr[0] = new CompareBean("zss", 20);
        arr[1] = new CompareBean("zss", 15);
        arr[2] = new CompareBean("zss", 30);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}


class CompareBean implements Comparable<CompareBean> {

    private String name;
    private Integer age;

    public CompareBean() {
    }

    public CompareBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ComBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(CompareBean obj) {
        return -Integer.compare(this.age, obj.age);
    }
}
