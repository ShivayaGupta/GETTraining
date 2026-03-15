package com.coforge.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.coforge.models.Employee;
import com.coforge.util.DBUtil;
public class EmployeeDAO {
 
   public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
	String query="select * from employees";
	List<Employee>empList=new ArrayList<Employee>();
	try(Connection con=DBUtil.getConnection();
			Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query)){
		while(rs.next()) {
			Employee e=new Employee();
			e.setEid(rs.getLong("eid"));
			e.setEname(rs.getString("ename"));
			e.setSalary(rs.getDouble("salary"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getString("mobile"));
			e.setDoj(rs.getDate("doj").toLocalDate());
			e.setDob(rs.getDate("dob").toLocalDate());
			empList.add(e);
		}
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return empList;
}
 public List<Employee> getbyId(long eid) throws ClassNotFoundException, SQLException{

 String query = "select eid,ename,salary,email,mobile,doj,dob from employees where eid=?";
    List<Employee> empList = new ArrayList<>();
    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setLong(1, eid);
ResultSet rs = ps.executeQuery();
		
	
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setEid(rs.getInt("eid"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getLong("salary"));
			employee.setEmail(rs.getString("email"));
			employee.setMobile(rs.getString("mobile"));
			employee.setDoj(rs.getDate("doj").toLocalDate());
			employee.setDob(rs.getDate("dob").toLocalDate());
			
			empList.add(employee);
		}
		return empList;
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}


     }

   public void addEmployee(Employee employee) throws ClassNotFoundException, SQLException{
	   String query="insert into employees(ename,salary,email,mobile,doj,dob) values(?,?,?,?,?,?) ";
	   try(Connection con =DBUtil.getConnection();
			   PreparedStatement ps=con.prepareStatement(query)){
		      // ps.setLong(1, employee.getEid());
		       ps.setString(1, employee.getEname());
		       ps.setDouble(2, employee.getSalary());
		       ps.setString(3, employee.getEmail());
		       ps.setString(4, employee.getMobile());
		       ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
			   ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));

		    	ps.executeUpdate();
				System.out.println("row inserted");
	}
   catch(ClassNotFoundException | SQLException e) {
   	e.printStackTrace();
}
   }
   public void updateEmployee(Employee employee) {
	   String query =
			    "UPDATE employees " +
			    "SET ename = ?, salary = ?, email = ?, mobile = ?, doj = ?, dob = ? " +
			    "WHERE eid = ?";

			try (Connection con = DBUtil.getConnection();
			     PreparedStatement ps = con.prepareStatement(query)) {

			    ps.setString(1, employee.getEname());
			    ps.setDouble(2, employee.getSalary()); // or setBigDecimal if DECIMAL in DB
			    ps.setString(3, employee.getEmail());
			    ps.setString(4, employee.getMobile());

			    // Assuming employee.getDoj()/getDob() return LocalDate; adjust if Date/String
			    ps.setDate(5, java.sql.Date.valueOf(employee.getDoj()));
			    ps.setDate(6, java.sql.Date.valueOf(employee.getDob()));

			    // Use the correct type for primary key 'eid'
			    // If eid is int:
			    // ps.setInt(7, employee.getEid());
			    // If eid is long:
			    ps.setLong(7, employee.getEid());

			    int rows = ps.executeUpdate();
			    System.out.println(rows + " row(s) updated");
			} catch (ClassNotFoundException | SQLException e) {
			    e.printStackTrace();
			}   }
		   
	  
   public Employee getEmployeeById(long eid) throws ClassNotFoundException, SQLException {
	    String sql = "SELECT eid, ename, salary, email, mobile, doj, dob FROM employees WHERE eid = ?";

	    try (Connection con = DBUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setLong(1, eid);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEid(rs.getLong("eid"));
	                emp.setEname(rs.getString("ename"));
	                emp.setSalary(rs.getDouble("salary"));
	                emp.setEmail(rs.getString("email"));
	                emp.setMobile(rs.getString("mobile"));

	                java.sql.Date dojSql = rs.getDate("doj");
	                emp.setDoj(dojSql != null ? dojSql.toLocalDate() : null);

	                java.sql.Date dobSql = rs.getDate("dob");
	                emp.setDob(dobSql != null ? dobSql.toLocalDate() : null);

	                return emp;
	            }
	        }
	    }
	    return null; // not found
	}
   
   public void delete(long eid) throws SQLException, ClassNotFoundException {

String sql = "DELETE FROM employees WHERE eid = ?";
try (Connection con = DBUtil.getConnection();
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setLong(1, eid);
    int rows = ps.executeUpdate(); // <-- execute the DELETE
    // optional: check result
    if (rows == 0) {
        // no row with this eid
    }
	    
	    
	
	   
   }}
public static List<Employee> getEmployeeByQuery(String search) {
	String query = "Select * from employees where ename like ? or email like ? or mobile like ? or doj like ? or dob like ?";
	try(Connection con=DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);){
		search = '%' + search + '%';
		ps.setString(1, search);
		ps.setString(2, search);
		ps.setString(3, search);
		ps.setString(4, search);
		ps.setString(5, search);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setEid(rs.getInt("eid"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getLong("salary"));
			employee.setEmail(rs.getString("email"));
			employee.setMobile(rs.getString("mobile"));
			employee.setDoj(rs.getDate("doj").toLocalDate());
			employee.setDob(rs.getDate("dob").toLocalDate());
			
			empList.add(employee);
		}
		return empList;
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}

   }}

