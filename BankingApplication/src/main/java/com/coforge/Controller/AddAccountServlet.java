package com.coforge.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coforge.LoggingFilter;
import com.coforge.Model.Account;
import com.coforge.dao.AccountDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAccountServlet
 */
//@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(AddAccountServlet.class);

	 private int accNo;
	 private String accHolderName;
	 private String accType;
	 private double balance;
    /**
     * Default constructor. 
     */
    public AddAccountServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method=\"post\">");
		out.println("<label>Account Number</label>");
		out.println("<input type=\"text\" name=\"accNo\">");
		out.println("<label>Account holder name </label>");
		out.println("<input type=\"text\" name=\"accHolderN\">");
		out.println("<label>Account type</label>");
		out.println("<input type=\"text\" name=\"accType\">");
		out.println("<label>Balance</label>");
		out.println("<input type=\"text\" name=\"balance\">");
		out.println("<button type=\"submit\">submit</button>");
		out.println("</html></body>");
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context =getServletContext();
		Connection con =(Connection) context.getAttribute("connection");
         int accNo=Integer.parseInt(request.getParameter("accNo"));
         String accHolderN=request.getParameter("accHolderN");
         String accType=request.getParameter("accType");
         int balance=Integer.parseInt(request.getParameter("balance"));
         Account acc = new Account(accNo,accHolderN,accType,balance);
         AccountDAO dao=new AccountDAO();
         try {
			dao.AddAccount(con, acc);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         response.sendRedirect("ViewAccount");
         
		//doGet(request, response);
	}

}
