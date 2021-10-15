package com.demo.exception;

import org.junit.Test;

/**
 * CustomExceptionTest
 *
 * @author gnl
 * @date 2021-02-06 14:26
 */

public class CustomExceptionTest {

    @Test
    public void test1() throws CustomException {
        throw new CustomException("出错啦");
    }

}
