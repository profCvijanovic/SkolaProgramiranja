package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PrikaziStudenteService;

/**
 * Servlet implementation class DodajStudentSmerController
 */
@WebServlet("/DodajStudentSmerController")
public class DodajStudentSmerController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrikaziStudenteService service = new PrikaziStudenteService();
		
		String idStudent = request.getParameter("idStudent");
		String idSmer = request.getParameter("smer");
		
		System.out.println("Smer: " + idSmer);
		System.out.println("Student: " + idStudent);
		
		service.dodajStudentaNaSmer(idStudent, idSmer);
		
		response.sendRedirect("PrikaziStudenteController");
	}

}
