<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
</head>
<body>
	<% User user = (User)session.getAttribute("user"); %>
	<h1>Dobrodosli na administratorsku stranicu</h1>
	<p>Ulogovan je: <%=user.getUserName()%></p>
	
	<%
	int brojRedova = 1;
	if(user.getUserName().equals("admin")){
		brojRedova = 5;
	}else{
		brojRedova = 10;
	}
	%>
	
	<table border = 1>
		<tr>
			<th>id</th>
			<th>ime</th>
		</tr>	
		<% 
			for(int i = 1; i <= brojRedova; i++){
		%>
		<tr>
			<td><%=i %></td>
			<td>ime<%=i %></td>
		</tr>
		<% } %>
	</table>


</body>
</html>