package com.demo.flyweight;

import java.util.HashMap;

/**
 * WebSiteFactory FlyweightFactory
 *
 * @author gnl
 */

public class WebSiteFactory {

    /**
     * ConcreteWebSite集合，充当池使用
     */
    private HashMap<String, ConcreteWebSite> pools = new HashMap<>();

    /**
     * getWebSite 根据网站类型，返回一个网站。如果没有就创建一个网站并放入池中，然后再将其返回
     * @param type
     * @return com.demo.flyweight.WebSite
     * @author gnl
     */
    public WebSite getWebSite(String type) {
        if (!pools.containsKey(type)) {
            pools.put(type, new ConcreteWebSite(type));
        }
        return pools.get(type);
    }

    /**
     * getWebSiteCount 获取池中网站的总数
     * @return int
     * @author gnl
     */
    public int getWebSiteCount() {
        return pools.size();
    }

}
