package com.demo.chainofresponsibility;

/**
 * Request
 *
 * @author gnl
 */

public class Request {

    private Integer id;
    private String type;
    private Integer day;

    public Request(Integer id, String type, Integer day) {
        this.id = id;
        this.type = type;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getDay() {
        return day;
    }
}
