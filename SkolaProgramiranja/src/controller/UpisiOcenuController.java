package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PolozeniIspiti;
import service.ProfesorService;

/**
 * Servlet implementation class UpisiOcenuController
 */
@WebServlet(description = "ocene upis", urlPatterns = { "/UpisiOcenuController" })
public class UpisiOcenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProfesorService service = new ProfesorService();
		
		String idPredmet = request.getParameter("idPredmet");
		String studentId = request.getParameter("studentId");
		String ocena = request.getParameter("ocena");
		
		service.upisiOcenu(Integer.parseInt(idPredmet),Integer.parseInt(studentId),Integer.parseInt(ocena));
		
		List<PolozeniIspiti> polozeniIspiti = service.vratiPolozeneIspite();
		
		request.setAttribute("polozeniIspiti", polozeniIspiti);
		request.setAttribute("idPredmet", idPredmet);
		request.getRequestDispatcher("view/prikazOcena.jsp").forward(request, response);
		
	}

}
