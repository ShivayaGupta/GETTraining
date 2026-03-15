package com.coforge.Controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coforge.dao.AccountDAO;
import com.coforge.Model.Account;
 
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
//@WebServlet("/SearchAccountServlet")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(Search.class);
    private final AccountDAO dao = new AccountDAO();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Search Account</title></head><body>");
        out.println("<h3>Search by Account No or Holder Name</h3>");
        out.println("<form method='post' action=''>");
        out.println("Search: <input type='text' name='q' required>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("</body></html>");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String q = request.getParameter("q");
 
        ServletContext ctx = getServletContext();
        Connection con = (Connection) ctx.getAttribute("connection");
 
        List<Account> results;
        try {
            results = dao.searchAccounts(con, q);
        } catch (Exception e) {
            throw new ServletException(e);
        }
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><title>Search Results</title></head><body>");
        out.println("<h3>Results for: " + (q == null ? "" : q) + "</h3>");
 
        if (results == null || results.isEmpty()) {
            out.println("<p>No matching accounts.</p>");
        } else {
            out.println("<table border='1' cellspacing='0' cellpadding='6'>");
            out.println("<thead><tr><th>Acc No</th><th>Holder</th><th>Type</th><th>Balance</th></tr></thead><tbody>");
            for (Account a : results) {
                out.println("<tr>");
                out.println("<td>" + a.getAccNo() + "</td>");
                out.println("<td>" + a.getAccHolderName() + "</td>");
                out.println("<td>" + a.getAccType() + "</td>");
                out.println("<td>" + a.getBalance() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody></table>");
        }
 
        out.println("<p><a href=\"SearchAccountServlet\">New search</a> | <a href=\"ViewAccountsServlet\">View all</a></p>");
        out.println("</body></html>");
    }
}