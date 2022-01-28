<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<link
	type="text/css"
	rel = "stylesheet"
	href="../css/style.css"
	/>
</head>
<body>
	<jsp:useBean id= "user" scope="session" class="model.User"></jsp:useBean>
	<h1>Dobrodosli na administratorsku stranicu</h1>
	<p style="display: inline;">Ulogovan je: ${user.userName}</p>
	<a href="logout.jsp" style="margin-left: 80px;">
		<img src = "../slike/logout.jfif"/>
	</a><br>
	<img src = "../slike/adminPage.jfif"/> <br>
	<a href="addStudent.jsp"><button>ADD STUDENT</button></a>
	<a href="addProfesor.jsp"><button>ADD PROFESOR</button></a>
	<a href="addAdministracija.jsp"><button>ADD ADMINISTRATOR</button></a><br><br>
	<a href="dodajPredmet.jsp"><button>DODAJ PREDMET</button></a>
	<a href="dodajPredmet.jsp"><button>DODAJ SMER</button></a> <br><br>
	<a href="../PrikaziProfesoreController"><button>PRIKAZI PROFESORE</button></a>



</body>
</html>