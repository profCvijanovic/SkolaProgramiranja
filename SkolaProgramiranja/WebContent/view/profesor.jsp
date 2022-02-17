<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profesor</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="../css/style.css"
	/>
</head>
<body>
	<jsp:useBean id= "user" scope="session" class="model.User"></jsp:useBean>
	<h1>Dobrodosli na profesorsku stranicu</h1>
	<p style="display: inline;">Ulogovan je profesor: ${user.userName}</p>
	<a href="logout.jsp" style="margin-left: 80px;">
		<img src = "../slike/logout.jfif"/>
	</a><br><br>
	<img src = "../slike/profa.jfif"/> <br>
	
	<form action = "../ProfileController" method="post">
		<input type="hidden" value="${user.idUser}" name = "idUser">
		<input type="submit" value="VIEW PROFILE">
	</form>
	
	<form action = "../ProfesorController" method="get">
		<input type="hidden" value="${user.idUser}" name = "idUser">
		<input type="submit" value="MOJI PREDMETI">
	</form>
	
	
	
	
</body>
</html>