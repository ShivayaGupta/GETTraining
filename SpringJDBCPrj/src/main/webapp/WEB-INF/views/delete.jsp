<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="../student/delete" method="get">
    <label>Student ID:</label>
    <input type="text" name="sid" required>
    <button type="submit">delete</button>
</form>

<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
    <h3><%= msg %></h3>
<%
}
%>

</body>
</html>