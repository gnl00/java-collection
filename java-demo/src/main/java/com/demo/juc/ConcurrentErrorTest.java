package com.demo.juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ConcurrentErrorTest
 *
 * @author gnl
 */

public class ConcurrentErrorTest {

    @Test
    public void testCurrentError() {
        List<String> list = new CopyOnWriteArrayList<>();

        List<String> concurrentList = Collections.synchronizedList(new ArrayList<>());
    }
}
