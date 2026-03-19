<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.coforge.entities.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<Student> slist = (ArrayList<Student>) request.getAttribute("slist");
if(slist != null){
    for(Student s : slist){
        out.println(s);
    }
}
%>

</body>
</html>