package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PrikaziProfesoreService;

/**
 * Servlet implementation class DodajPredmetProfesoruController
 */
@WebServlet("/DodajPredmetProfesoruController")
public class DodajPredmetProfesoruController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrikaziProfesoreService service = new PrikaziProfesoreService();
		
		String idProfesor = request.getParameter("idProfesor");
		String idPredmet = request.getParameter("idPredmet");
		
		service.dodajPredmetProfesoru(idProfesor, idPredmet);
		
		response.sendRedirect("PredmetiProfesoriController?idProfesor=" + idProfesor );
		
		
	}

}
