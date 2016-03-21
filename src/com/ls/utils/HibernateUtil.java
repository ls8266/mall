package com.ls.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	
	private HibernateUtil(){
		
	}
	
	static {
		Configuration config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}
