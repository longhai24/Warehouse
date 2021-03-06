package com.accp.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Column {
	String name();

	String type();

	int length();
	
	boolean isNull() default false;

	boolean isPrimaryKey() default false;

	boolean isIdentity() default false;

}
