package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.User;
import model.UserDetails;
import model.UserType;
import service.AddStudentService;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet(description = "dodavanje studenta", urlPatterns = { "/AddStudentController" })
public class AddStudentController extends HttpServlet {
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
		String indexNo = request.getParameter("indexNo");
		
		User user = service.popuniUsera(userName,password, UserType.STUDENT);
		UserDetails details = service.popuniUserDetails(firstName, lastName, email, mobilePhone, country, city, street, user);
		Student student = new Student();
		student.setIndexNo(indexNo);
		
		boolean snimiStudenta = service.ubaciStudenta(user,details,student);
		
		if(snimiStudenta) {
			response.sendRedirect("view/admin.jsp");
		}else {
			response.sendRedirect("view/addStudent.jsp");
		}
		
	}

}
