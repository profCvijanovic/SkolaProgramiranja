package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profesor;
import model.UserDetails;
import service.ProfesorService;

/**
 * Servlet implementation class ProfesorController
 */
@WebServlet("/ProfesorController")
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfesorService service = new ProfesorService();
		
		String idUser = request.getParameter("idUser");
		
		UserDetails detalj = service.vratiUserDetailsZaUsera(idUser);
		
		Profesor profesor = service.vratiProfesoraPoId(detalj.getIdUserDetails());
		
		request.setAttribute("profesor", profesor);
		
		request.getRequestDispatcher("view/profesoroviPredmeti.jsp").forward(request, response);
		
	}

}
