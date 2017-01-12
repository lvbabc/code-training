package com.lvb.spring;

import java.lang.reflect.Field;

public class StringPractice {

	public static void main(String args[]) throws Exception {

		String s = "Hello World";

		System.out.println("s = " + s); //Hello World

		//获取String类中的value字段
		Field valueField = String.class.getDeclaredField("value");

		//改变value属性的访问权限
		valueField.setAccessible(true);

		char[] value = (char[]) valueField.get(s);

		//改变value所引用的数组中的第5个字符
		value[5] = '_';

		System.out.println("s = " + s); //Hello_World
	}
}