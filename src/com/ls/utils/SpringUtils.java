package com.ls.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	private static ApplicationContext context;
	
	static{
		context = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
	}
	public static ApplicationContext getApplicationContext(){
		return context;
	}
}
