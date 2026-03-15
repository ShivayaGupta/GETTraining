package com.coforge;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LogoutServlet extends HttpServlet {
 
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 
  String username = request.getParameter("username");
  String password = request.getParameter("password");
 
  if(username.equals("admin") && password.equals("1234")) {
 
      HttpSession session = request.getSession();
      session.setAttribute("user", username);
 
      response.sendRedirect("home");
 
  } else {
      response.getWriter().println("Invalid Login");
  }
}
}