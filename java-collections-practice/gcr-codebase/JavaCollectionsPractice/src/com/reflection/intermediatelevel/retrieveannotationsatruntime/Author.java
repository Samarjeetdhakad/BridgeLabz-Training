package com.reflection.intermediatelevel.retrieveannotationsatruntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
    String value();
}