package com.coforge.Controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coforge.dao.AccountDAO;
 
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AccountDAO dao = new AccountDAO();
    private static final Logger logger = LogManager.getLogger(DeleteServlet.class);
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Delete Account</title></head><body>");
        out.println("<h3>Delete Account</h3>");
        out.println("<form method='post' action=''>");
        out.println("Account Number: <input type='text' name='accno' required><br><br>");
        out.println("<input type='submit' value='Delete Account'>");
        out.println("</form>");
        out.println("</body></html>");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String accno = request.getParameter("accno");
        int accNoInt = (accno == null || accno.isBlank()) ? 0 : Integer.parseInt(accno);
 
        ServletContext context = getServletContext();
        Connection con = (Connection) context.getAttribute("connection");
 
        int data;
        try {
            data = dao.deleteAccount(con, accNoInt);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
 
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Deleted</title></head><body>");
        out.println("<h4>Account " + accNoInt + (data > 0 ? " deleted." : " not found.") + "</h4>");
        out.println("<p><a href=\"DeleteAccountServlet\">Delete another</a> | <a href=\"ViewAccountsServlet\">View accounts</a></p>");
        out.println("</body></html>");
    }
}