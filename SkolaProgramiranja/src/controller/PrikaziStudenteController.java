package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Smer;
import model.Student;
import service.PrikaziStudenteService;

/**
 * Servlet implementation class PrikaziStudenteController
 */
@WebServlet(description = "studenti", urlPatterns = { "/PrikaziStudenteController" })
public class PrikaziStudenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrikaziStudenteService service = new PrikaziStudenteService();
		
		List<Student> sviStudenti = service.vratiSveStudente();
		List<Smer> sviSmerovi = service.vratiSveSmerove();
		
		request.setAttribute("sviStudenti", sviStudenti);
		request.setAttribute("sviSmerovi", sviSmerovi);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/studentiSmer.jsp");
		dispatcher.forward(request, response);
		
	}

}
