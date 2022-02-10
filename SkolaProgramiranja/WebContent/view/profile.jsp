<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.UserDetails" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="css/style.css"
/>
</head>
<body>
	<h1>PROFILE</h1>
	<jsp:useBean id= "details" scope="session" class="model.UserDetails"></jsp:useBean>
	<a href = "view/profesor.jsp"> back to PROFESOR page</a><br><br>
	
	<table border="1px">
		<tr>
			<th> IME </th>
			<th> PREZIME </th>
		</tr>
		<tr>
			<td>${details.firstName}</td>
			<td>${details.lastName}</td>
		</tr>
	</table>


	<p>ADRESA:</p>
	<table border="1px">
		<tr>
			<th> DRZAVA </th>
			<th> GRAD </th>
			<th> ULICA </th>
		</tr>
		<tr>
			<td>${details.address.country}</td>
			<td>${details.address.city}</td>
			<td>${details.address.street}</td>
		</tr>
	</table> 
	
	<p>KONTAKT:</p>
	<table border="1px">
		<tr>
			<th> EMAIL </th>
			<th> TELEFON </th>
		</tr>
		<tr>
			<td>${details.contact.email}</td>
			<td>${details.contact.mobilePhone}</td>
		</tr>
	</table>
	
</body>
</html>