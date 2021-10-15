package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TokenRequest 自定义注解
 * @Retention 注解起作用的时期 类似于作用域scope
 *  1. SOURCE 供编译器识别，编译期起作用
 *  2. CLASS 保存在 .class 文件中，不会被加载进入JVM
 *  3. RUNTIME 运行时期可以被程序读取，会被加载进JVM
 *
 * @Target 表示注解可以标注在哪些地方
 *  1. 类 ElementType.TYPE
 *  2. 方法 ElementType.METHOD
 *  3. 参数位 PARAMETER
 *  4. 构造方法 CONSTRUCTOR
 *  5. 局部变量 LOCAL_VARIABLE
 *  6. 标注在注解类 ANNOTATION_TYPE
 *  ...
 *
 * @author gnl
 */

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenRequired {

    /**
     * 实际使用中可以不用添加 required 属性，仅把注解当作标记使用，只要包含注解即视为需要token
     *
     * 属性类型 属性名 default 设置默认值
     */
    boolean required() default false;

}
