package com.darknessvenom.annotaions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 代表这个注解，可以被javadoc 处理的（加不加都行）
@Documented
// RetentionPolicy 生命周期，一共有三个
// SOURCE 只留在源码，编译好后的代码是不有该注解的，该注解一旦编译就不存在了 ；
// class 只停留在字节码，运行时不会有；
// RUNTIME 运行时需要反射来获取该注解
@Retention(RetentionPolicy.RUNTIME)
// 该注解打在哪个地方，方法，参数，类。。。。。。
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface NotNull {
    /**
     * 获取参数名
     */
    String fileName();
}
