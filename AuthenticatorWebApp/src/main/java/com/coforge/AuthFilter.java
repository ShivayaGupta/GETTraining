package com.coforge;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebFilter({"/home","/profile","/dashboard"})
public class AuthFilter implements Filter {
 
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
throws IOException, ServletException {
 
  HttpServletRequest request = (HttpServletRequest) req;
  HttpServletResponse response = (HttpServletResponse) res;
 
  HttpSession session = request.getSession(false);
 
  if(session != null && session.getAttribute("user") != null) {
 
      chain.doFilter(req, res); // allow request
 
  } else {
 
      response.sendRedirect("login.jsp");
  }
}
}