package com.demo.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * MapTest
 *
 * @author gnl
 */

public class MapTest {
    @Test
    public void test01() {
        Map<String, String> map = new HashMap<>();

        map.put("k1", "v1");
        map.put("k2", "v1");
        map.put("k3", "v1");
        map.put("k4", "v1");
        map.put("k5", "v1");
        map.put("k6", "v1");
        map.put("k7", "v1");
        map.put("k8", "v1");
        map.put("k9", "v1");

        System.out.println(map);
    }
}
