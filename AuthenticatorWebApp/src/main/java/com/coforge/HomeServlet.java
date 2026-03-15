package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger=LogManager.getLogger(HomeServlet.class);

    /**
     * Default constructor. 
     */
    public HomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession(false);
		String user=(String) session.getAttribute("user");
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Welcome " + user + "</h2>");
		out.println("<h3>This is Home Page</h3>");
		 
		out.println("<a href='profile'>Profile</a><br><br>");
		out.println("<a href='dashboard'>Dashboard</a><br><br>");
		out.println("<a href='logout'>Logout</a>");
		 
		out.println("</body>");
		out.println("</html>");
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
