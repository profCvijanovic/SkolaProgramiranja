package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PredmetSmerService;

/**
 * Servlet implementation class ObrisiPredmetSmerController
 */
@WebServlet(description = "brisanje", urlPatterns = { "/ObrisiPredmetSmerController" })
public class ObrisiPredmetSmerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PredmetSmerService service = new PredmetSmerService();
		
		String idPredmet = request.getParameter("idPredmet");
		String idSmer = request.getParameter("idSmer");
		
		System.out.println("Izabran smer: " + idSmer);
		System.out.println("Izabran predmet: " + idPredmet);
		
		service.obrisiPredmetSmer(idSmer, idPredmet);
		
		response.sendRedirect("SmerPredmetController");
		
	}

}
