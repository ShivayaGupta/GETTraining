<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.coforge.entities.Student"%>
<!DOCTYPE html>
<html>
<body>

<h2>Get Student</h2>

<form action="../student/get" method="get">
    <label>Student ID:</label>
    <input type="text" name="sid" required>
    <button type="submit">Search</button>
</form>

<%
Student s = (Student) request.getAttribute("student");
if (s != null) {
%>
    <h3>Student Details</h3>
    ID: <%= s.getSid() %><br>
    Name: <%= s.getSname() %><br>
    Age: <%= s.getCourse() %><br>
<%
}
%>

</body>
</html>