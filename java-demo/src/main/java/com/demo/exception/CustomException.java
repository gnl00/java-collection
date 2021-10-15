package com.demo.exception;

/**
 * CustomException 自定义异常类
 *
 * @author gnl
 */

public class CustomException extends RuntimeException {

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
}
