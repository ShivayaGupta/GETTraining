package com.coforge;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class First
*/
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor.
     */
    public login() {
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     
        response.setContentType("text/html;charset=UTF-8");

    
        String userId = request.getParameter("userId");
        String pwd   = request.getParameter("pwd");

        RequestDispatcher rd;
        String ok = userStore.validate(userId, pwd);

        if (ok!=null) {
            request.setAttribute("uname", ok);
            rd = request.getRequestDispatcher("/Welcome.jsp");
            rd.forward(request, response);
            return; 
        } else {
         
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html><head><meta charset='UTF-8'><title>Login</title></head><body>");
                out.println("<h3 style='color: #d9534f;'>INVALID CREDENTIALS</h3>");
                out.println("<a href='" + request.getContextPath() + "/login.jsp'>Back to Login</a>");
                out.println("</body></html>");
            }

        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 
}