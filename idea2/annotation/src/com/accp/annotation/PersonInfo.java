package com.accp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1.定义元注解
@Retention(RetentionPolicy.RUNTIME)  //非常重要
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface PersonInfo {
	String enName();
	int age();
	char sex() default '女';
}
