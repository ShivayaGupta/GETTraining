package com.coforge.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static SessionFactory sessionFactory=buildSessionFactory();
 public static SessionFactory buildSessionFactory() {
	   
	    SessionFactory sf = new Configuration().configure().buildSessionFactory();
         return sf;
 }
 public static SessionFactory getSessionFactory() {
	 return sessionFactory;
 }
}
