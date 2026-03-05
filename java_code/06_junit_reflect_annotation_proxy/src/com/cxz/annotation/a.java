package com.cxz.annotation;

public @interface a {
    String name();
    int age() default 18;
    String[] city();
}
