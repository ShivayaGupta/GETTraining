package com.coforge;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class Signup extends HttpServlet {
   
   
    public Signup() { }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String userid  = request.getParameter("userid");
        String uname   = request.getParameter("uname");
        String pwd     = request.getParameter("pwd");
        String emailid = request.getParameter("emailid");
        String mob = request.getParameter("mobileno");
        
          User user = new User(userid,uname,pwd,emailid,mob);
        
                   userStore.addUser(user);
        

        
        response.sendRedirect("index.jsp");
        // Do NOT write to response or call doGet() after forward
    }
}
