<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Predmet" %>
<%@ page import="model.Profesor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profesori predmeti</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="css/style.css"
	/>
</head>
<body>

<jsp:useBean id = "sviPredmeti" scope="request" class="java.util.ArrayList" ></jsp:useBean>
<jsp:useBean id = "profesor" scope="request" class="model.Profesor"></jsp:useBean>

	<h1>SVE O PREDMETIMA PROFESORA</h1>
	<a href = "PrikaziProfesoreController">back to PROFESOR TABLE</a> <br><br>
	
	<p>Dobodosli na stranicu profesora  ${profesor.firstName} ${profesor.lastName}</p>
	
	<p>TABELA PREDMETA</p>
	<table border = "1">
		<tr>
			<th>NAZIV PREDMETA</th>
			<th>SIFRA PREDMETA</th>
		</tr>
		
		<c:forEach var="p" items="${profesor.predmentiKojePredaje}">
			<tr>
				<td>${p.nazivPredmeta}</td>
				<td>${p.sifraPredmeta}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p>DODAJ PREDMET</p>
	<form action="DodajPredmetProfesoruController" method="get">
		<input type="hidden" name = "idProfesor" value="${profesor.idUserDetails}">
		<select name = "idPredmet">
		 <c:forEach var="pr" items="${sviPredmeti}">
		 	<option value = "${pr.idPredmet}">${pr.nazivPredmeta}</option>
		 </c:forEach>
		</select>
		<input type="submit" value="DODAJ PREDMET PROFESORU">
	</form>

</body>
</html>