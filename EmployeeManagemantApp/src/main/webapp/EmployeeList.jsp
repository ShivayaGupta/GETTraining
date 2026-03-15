<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.coforge.models.Employee,java.time.LocalDate" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employee List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
</head>
<body>

<%
  ArrayList<Employee> empList = (ArrayList<Employee>) request.getAttribute("empList");
  String error = (String) request.getAttribute("error"); // in case controller sets an error
%>

<div class="container mt-4">
  <div class="card shadow">
    <div class="card-header bg-primary d-flex align-items-center justify-content-between">
      <h1 class="text-light m-0">Employee List</h1>
      <div class="d-flex gap-2">
        <a href="employee?action=add" class="btn btn-success">Add Employee</a>
        <a href="Home.jsp" class="btn btn-warning">Home</a>
      </div>
      <br>
				<br>
				<form class="d-flex gap-2 flex-row" action="employee">
					<input type="hidden" name="action" value="search" >
					<input type="text" class="form-control" placeholder="Enter Employee Name, Email, DOJ, DOB, Mobile to search" name="search" >
					<button class="btn btn-dark" >Search</button>
				</form>
    </div>

    <div class="card-body">
      <% if (error != null && !error.isEmpty()) { %>
        <div class="alert alert-danger"><%= error %></div>
      <% } %>

      <div class="table-responsive"><!-- fixed class name -->
        <table class="table table-bordered table-striped align-middle text-center">
          <thead class="table-dark">
          <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Salary</th>
            <th>Employee Email</th>
            <th>Employee Mobile</th>
            <th>Employee DOJ</th>
            <th>Employee DOB</th>
            <th>Actions</th>
          </tr>
          </thead>
          <tbody>
          <% if (empList != null && !empList.isEmpty()) {
               for (Employee emp : empList) {
          %>
            <tr>
              <td><%= emp.getEid() %></td>
              <td><%= emp.getEname() %></td>
              <td><%= emp.getSalary() %></td>
              <td><%= emp.getEmail() %></td>
              <td><%= emp.getMobile() %></td>
              <td><%= emp.getDoj() != null ? emp.getDoj().toString() : "" %></td>
              <td><%= emp.getDob() != null ? emp.getDob().toString() : "" %></td>
              <td class="d-flex gap-2 justify-content-center">
                <a href="employee?action=edit&eid=<%= emp.getEid() %>" class="btn btn-success btn-sm">Edit</a>
                <a href="employee?action=delete&eid=<%= emp.getEid() %>"
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Do you want to delete this employee?')">Delete</a>
            <a href="employee?action=viewById&eid=<%= emp.getEid() %>" class="btn btn-success btn-sm">View</a>
                   
              </td>
            </tr>
          <% } } else { %>
            <tr>
              <td colspan="8">No Employees Found</td>
            </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

</body>
</html>