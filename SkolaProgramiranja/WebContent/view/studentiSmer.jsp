<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Student" %>
<%@ page import="model.Smer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>studenti - smer</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="css/style.css"
	/>
</head>
<body>
	<jsp:useBean id = "sviStudenti" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id = "sviSmerovi" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<h1>STUDENTI I SMEROVI</h1>
	
	<a href = "view/admin.jsp">back to ADMIN page</a><br>
	<table>
		<tr>
			<th>BROJ INDEXA</th>
			<th>IZABERI SMER</th>
		</tr>
		
		<c:forEach var = "student" items="${sviStudenti}">
			<tr>
				<td>${student.indexNo}</td>
				<td>
					<form action="DodajStudentSmerController">
					
						<select name = "smer">
						 <c:forEach var = "smerovi" items="${sviSmerovi}">
						 	<option value="${smerovi.idSmer}">${smerovi.nazivSmera}</option>
						 </c:forEach>
						</select>
						
						<input type="hidden" name = "idStudent" value="${student.idUserDetails}">
			
						<input type = "submit" value="UBACI STUDENTA NA SMER">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>