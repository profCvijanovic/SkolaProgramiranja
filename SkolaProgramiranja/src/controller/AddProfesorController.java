package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import model.User;
import model.UserType;
import service.AddStudentService;

/**
 * Servlet implementation class AddAdministratorController
 */
@WebServlet(description = "dodavanje administratora", urlPatterns = { "/AddAdministratorController" })
public class AddProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AddStudentService service = new AddStudentService();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobilePhone = request.getParameter("mobilePhone");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String identificationNumber = request.getParameter("identificationNumber");
		
		User user = service.popuniUsera(userName,password, UserType.ADMINISTRACIJA);
		Administrator administrator = service.popuniAdministrator(firstName, lastName, email, mobilePhone, country, city, street, user, identificationNumber);
		
		boolean snimiAdministratora= service.ubaciAdministrator(user,administrator);
		
		if(snimiAdministratora) {
			response.sendRedirect("view/admin.jsp");
		}else {
			response.sendRedirect("view/addAdministracija.jsp");
		}
		
	}

}
