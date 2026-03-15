package com.coforge.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coforge.Model.Account;
import com.coforge.dao.AccountDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletContext;

/**
 * Servlet implementation class ViewAccount
 */
//@WebServlet("/ViewAccount")
public class ViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger logger = LogManager.getLogger(ViewAccount.class);
     private AccountDAO dao=new AccountDAO();
    /**
     * Default constructor. 
     */
    public ViewAccount() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context =getServletContext();
		Connection con =(Connection) context.getAttribute("connection");
		List<Account> accList = new ArrayList<Account>();
		try {
			accList=dao. getAllAccounts(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border=3px>");
		out.println("<thead><tr><th>account number</th><th>Account HolderName</th>");
		out.println("<th>Account type</th><th>Balance</th></tr></thead>");
		out.println("<tbody>");
		for(Account acc:accList) {
			out.println("<tr><td>"+acc.getAccNo()+"</td>");
			out.println("<td>"+acc.getAccHolderName()+"</td>");
			out.println("<td>"+acc.getAccType()+"</td>");
			out.println("<td>"+acc.getBalance()+"</td></tr>");
			

		}
		out.println("</tbody></table></body><html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
