<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Predmet" %>
<%@ page import="model.Smer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>smerovi i predmeti</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="css/style.css"
/>
</head>
<body>
<jsp:useBean id = "sviPredmeti" scope="request" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id = "sviSmerovi" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<h1>PREDMETI I SMEROVI</h1>

<a href = "view/admin.jsp">back to ADMIN page </a> <br><br>
Lista smerova: ${sviSmerovi.size()} <br>
Lista predmeta: ${sviPredmeti.size()}<br><br>

<table border="1px">
	<tr>
		<th>SMER</th>
		<th>NAZIV PREDMETA</th>
	</tr>
	<c:forEach var = "s" items = "${sviSmerovi}">
		<tr>
			<td>${s.nazivSmera}</td>
			<td>
				<c:forEach var= "p" items="${s.predmetiNaSmeru}">
					${p.nazivPredmeta}<br>
				</c:forEach> 
				
			</td>
		</tr>
	</c:forEach>
</table><br><br>


<form action = "PoveziSmerPredmetController" method="get">

Predmet:
<select name = "predmet">
	<c:forEach var = "p" items="${sviPredmeti}">
		<option value="${p.idPredmet}">${p.nazivPredmeta}</option>
	</c:forEach>
</select>
Smer: 
<select name = "smer">
	<c:forEach var = "s" items="${sviSmerovi}">
		<option value="${s.idSmer}">${s.nazivSmera}</option>
	</c:forEach>
</select>

<input type="submit" value="POVEZI"/>

</form>

</body>
</html>