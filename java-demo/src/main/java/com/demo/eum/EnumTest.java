package com.demo.eum;

import java.util.Arrays;

/**
 * EnumTest
 *
 * @author gnl
 */

public class EnumTest {
    public static void main(String[] args) {
        WeekDay[] values = WeekDay.values();
        Arrays.stream(values).forEach(System.out::println);

        String name = WeekDay.FRI.name();
        // FRI
        System.out.println(name);

        // 返回定义的常量的顺序，下标从0开始
        int ordinal = WeekDay.FRI.ordinal();
        // 4
        System.out.println(ordinal);
        System.out.println("**********************");
        System.out.println(Season.SPRING.toString());
        System.out.println("**********************");
        Season2.SPRING.showInfo();
    }
}

enum WeekDay {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN;
}

enum Season {

    SPRING("春天", "踩踩踩踩踩踩踩踩"),
    SUMMER("夏天", "嘻嘻嘻嘻嘻嘻嘻嘻"),
    AUTUMN("秋天", "钱钱钱钱钱钱钱钱"),
    WINTER("冬天", "顶顶顶顶顶顶顶顶");

    private String name;
    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

interface ISeason {
    /**
     * showInfo
     */
    void showInfo();
}

enum Season2 implements ISeason {

    SPRING("春天") {
        @Override
        public void showInfo() {
            System.out.println("春天啊");
        }
    };


    private String name;

    Season2(String name) {
        this.name = name;
    }
}
