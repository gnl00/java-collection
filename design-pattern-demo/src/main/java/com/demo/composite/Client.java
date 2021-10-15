package com.demo.composite;

/**
 * Client
 *
 * @author gnl
 */

public class Client {
    public static void main(String[] args) {
        Component university = new University("jxnu", "jxnu good good good");
        Component sos = new College("sos", "sos nb");

        university.add(sos);
        university.add(new College("teach", "teach good"));
        university.add(new College("cs", "cs good good"));

        sos.add(new Department("web", "web1111"));
        sos.add(new Department("android", "android22222"));
        sos.add(new Department("big data", "bigdata3333"));

        university.show();
        sos.show();
    }
}
