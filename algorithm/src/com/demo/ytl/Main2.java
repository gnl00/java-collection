package com.demo.ytl;

import java.util.ArrayList;
import java.util.List;

/**
 * Main2
 *
 * @author gnl
 */

public class Main2 {
    public static void main(String[] args) {
        List<Sheep> sheepList = new ArrayList<>();
    }
}

class Sheep {

    private Integer age;

    public Sheep() {
    }

    public Sheep(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "age=" + age +
                '}';
    }
}
