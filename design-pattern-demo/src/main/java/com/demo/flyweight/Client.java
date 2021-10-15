package com.demo.flyweight;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite blog = factory.getWebSite("blog");
        WebSite news = factory.getWebSite("news");
        WebSite music = factory.getWebSite("music");
        blog.controller("gnl");
        news.controller("admin");
        music.controller("aaa");

        System.out.println(factory.getWebSiteCount());
    }
}
