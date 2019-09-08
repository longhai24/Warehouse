package com.accp.annotation.dao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Column {
	String name();

	String type() default "varchar";

	int length() default 20;

	boolean isPrimaryKey() default true;

	boolean isIdentity() default false;

	boolean isNull() default true;
}
