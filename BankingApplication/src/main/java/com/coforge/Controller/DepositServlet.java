package com.coforge.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coforge.Model.Account;
import com.coforge.dao.AccountDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositServlet
 */
//@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger logger = LogManager.getLogger(DepositServlet.class);
    /**
     * Default constructor. 
     */
    public DepositServlet() {
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
		out.println("<label>Search</label>");
		out.println("<input type=\"text\" name=\"accNo\">");
		
		out.println("<label>Enter Amount:</label>");
		out.println("<input type=\"text\" name=\"amt\">");
		out.println("<button type=\"submit\">submit</button>");
		out.println("</html></body>");
		try {
			doPost(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context =getServletContext();
		Connection con =(Connection) context.getAttribute("connection");
         int accNo=Integer.parseInt(request.getParameter("accNo"));
                  int amt=Integer.parseInt(request.getParameter("amt"));
         //Account acc = new Account();
         AccountDAO dao=new AccountDAO();
         try {
			dao.deposit(con, accNo,amt);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         response.sendRedirect("ViewAccount");
         
		//doGet(request, response);
		//doGet(request, response);
	}

}
