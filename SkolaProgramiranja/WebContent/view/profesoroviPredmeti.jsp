<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Profesor" %>
<%@ page import="model.Predmet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>predmeti</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="css/style.css"
	/>
</head>
<body>

	<h1>PREDMETI</h1>
	
	<jsp:useBean id = "profesor" scope="request" class="model.Profesor"></jsp:useBean>
	
	<a href = "view/profesor.jsp">back to PROFESOR page </a><br><br>
	
	<table>
		<tr>
			<td>NAZIV PREDMETA</td>
		</tr>
		<c:forEach var = "p" items="${profesor.predmentiKojePredaje}">
			<tr>
				<td>
				<c:url var="pp" value="SpisakStudenataController">
					<c:param name="idPredmeta" value="${p.idPredmet}"/>
				</c:url>
				 <a href = "${pp}">${p.nazivPredmeta}</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>