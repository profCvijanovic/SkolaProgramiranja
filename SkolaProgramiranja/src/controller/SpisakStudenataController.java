package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Predmet;
import model.Smer;
import model.Student;
import service.ProfesorService;

/**
 * Servlet implementation class SpisakStudenataController
 */
@WebServlet("/SpisakStudenataController")
public class SpisakStudenataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfesorService service = new ProfesorService();
		
		String idPredmeta = request.getParameter("idPredmeta");
		System.out.println("Predmet: " + idPredmeta);
		
		List<Smer> smeroviPredmeta = service.vratiSveSmerovePredmeta(idPredmeta);
		List<Student> sviStudenti = service.vratiSveStudenteSmerova(smeroviPredmeta);
		Predmet predmet = service.vratiPredmetPoId(idPredmeta);
		
		request.setAttribute("sviStudenti", sviStudenti);
		request.setAttribute("predmet", predmet);
		
		request.getRequestDispatcher("view/spisakStudenata.jsp").forward(request, response);
		
		
	}



}
