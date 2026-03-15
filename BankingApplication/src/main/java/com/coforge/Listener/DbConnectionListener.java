package com.coforge.Listener;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DbConnectionListener
 *
 */
@WebListener
public class DbConnectionListener implements ServletContextListener {
   private Connection connection;
    /**
     * Default constructor. 
     */
    public DbConnectionListener() {
        // TODO Auto-generated constructor stub
    }
    public void contextInitialized(ServletContextEvent sce) {
    	ServletContextListener.super.contextInitialized(sce);
    	try {
    		getClass().forName("com.mysql.cj.jdbc.Driver");
    		String url = "jdbc:mysql://localhost:3306/cfgdb";
    		String uname="root";
    		String pwd="Cfg@1234";
    		connection=DriverManager.getConnection(url,uname,pwd);
    		ServletContext context=sce.getServletContext();
    		context.setAttribute("connection", connection);
    		System.out.println("connection created and added to context");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    @Override
    	public void contextDestroyed(ServletContextEvent sce) {
    		// TODO Auto-generated method stub
    	   
    		ServletContextListener.super.contextDestroyed(sce);
    		try {
    			if(connection !=null && !connection.isClosed()) {
    				connection.close();
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
	
}
