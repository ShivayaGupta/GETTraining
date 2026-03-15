package com.coforge.Controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
import com.coforge.dao.EmployeeDAO;
import com.coforge.models.Employee;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class EmployeeServlet
*/
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor. 
     */
	private static EmployeeDAO dao=null;
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	dao=new EmployeeDAO();
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String action= request.getParameter("action");
		switch(action) {
		case "list":
			List<Employee> empList=new ArrayList<Employee>();

           try {
            empList = dao.getAllEmployees(); // Prefer DAO to handle/throw SQLException
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally set an error and show an error page or same list page with message
            request.setAttribute("error", "Failed to load employees: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Only keep this if your DAO/DBUtil actually throws it
            e.printStackTrace();
            request.setAttribute("error", "Driver not found: " + e.getMessage());
        }
        request.setAttribute("empList", empList);
        RequestDispatcher rd = request.getRequestDispatcher("EmployeeList.jsp");
        rd.forward(request, response);
        break;
		case "add":
			 rd=request.getRequestDispatcher("employeeform.jsp");
			 rd.forward(request, response);
			 break;
		case "delete":
			   long eid1= Long.parseLong(request.getParameter("eid"));
			//rd=request.getRequestDispatcher("employeeform.jsp");
			//rd.forward(request,response);
			Employee emp = null;
			try {
			dao.delete(eid1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//rd.forward(request,response);


		  //  request.setAttribute("Employee", emp);
		   // request.setAttribute("editmode", true);
		    
	//	request.getRequestDispatcher("employeeform.jsp").forward(request, response);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		  break;


		case "edit": 
             long eid= Long.parseLong(request.getParameter("eid"));
		    Employee emp1 = null;
			try {
				emp1 = dao.getEmployeeById(eid);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    

		    request.setAttribute("Employee", emp1);
		    request.setAttribute("editmode", true);
		    
		request.getRequestDispatcher("employeeform.jsp").forward(request, response);
		  break;

//case "viewById": 
//	int eid_view= Integer.parseInt(request.getParameter("eid"));
//	List<Employee> emp_view = dao.getById(eid_view);
//	if(emp_view==null) return;
//	request.setAttribute("employee", emp_view);
//	request.setAttribute("editable", false);
//	rd = request.getRequestDispatcher("employeeform.jsp");
//	rd.forward(request, response);
	//break;
       case "search":
	   String search= request.getParameter("search");
	   List<Employee> empListSearch = EmployeeDAO.getEmployeeByQuery(search);
	   request.setAttribute("empList", empListSearch);
	   rd = request.getRequestDispatcher("EmployeeList.jsp");
	   rd.forward(request, response);
	   break;
       case "viewById":
    	   long eid11= Long.parseLong(request.getParameter("eid"));
			List<Employee> empListSearch1 = null;
			try {
				empListSearch1 = dao.getbyId(eid11);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   request.setAttribute("empList", empListSearch1);
    	   rd = request.getRequestDispatcher("EmployeeList.jsp");
    	   rd.forward(request, response);
       break;


    

		

	
		default:
			out.println("no action selected");
		}
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Read params safely
		String eid       = request.getParameter("eid");
		String ename     = request.getParameter("ename");
		String salaryStr = request.getParameter("salary");
		String email     = request.getParameter("email");
		String mobile    = request.getParameter("mobile");
		String dojStr    = request.getParameter("doj"); // "yyyy-MM-dd"
		String dobStr    = request.getParameter("dob");

		double salary = 0.0;
		try {
		    if (salaryStr != null && !salaryStr.isEmpty()) {
		        salary = Double.parseDouble(salaryStr);
		    }
		} catch (NumberFormatException nfe) {
		    salary = 0.0;
		}

		java.time.LocalDate doj = null;
		if (dojStr != null && !dojStr.isEmpty()) {
		    try {
		        doj = java.time.LocalDate.parse(dojStr);
		    } catch (java.time.format.DateTimeParseException dtpe) {
		        doj = null;
		    }
		}

		java.time.LocalDate dob = null;
		if (dobStr != null && !dobStr.isEmpty()) {
		    try {
		        dob = java.time.LocalDate.parse(dobStr);
		    } catch (java.time.format.DateTimeParseException dtpe) {
		        dob = null;
		    }
		}

		try {
		    if (eid == null || eid.isEmpty()) {
		        // INSERT
		        Employee e = new Employee(ename, salary, email, mobile, doj, dob);
		        dao.addEmployee(e);
		    } else {
		        // UPDATE
		        try {
		            long empid = Long.parseLong(eid);
		            Employee emp = new Employee(empid, ename, salary, email, mobile, doj, dob);
		            dao.updateEmployee(emp); // <-- use update, not add
		        } catch (NumberFormatException nfe) {
		            // Invalid eid passed; choose one: treat as insert OR handle error
		            // Here we handle as a bad request or skip
		            // Option 1: redirect with an error param
		            response.sendRedirect("employee?action=list&error=invalidId");
		            return;
		        }
		    }
		} catch (ClassNotFoundException | SQLException ex) {
		    ex.printStackTrace();
		    // Optionally add an error flag in redirect:
		    // response.sendRedirect("employee?action=list&error=db");
		    // return;
		}

		response.sendRedirect("employee?action=list");
 
}}


