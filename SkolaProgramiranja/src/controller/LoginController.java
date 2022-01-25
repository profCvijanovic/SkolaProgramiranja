package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserType;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "ovo je servlet za login", urlPatterns = { "/LoginControllerPath" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Dobrodosli u doPost");
		// povezivanje na service
		LoginService service = new LoginService();
		// prihvatamo parametre iz request object-a
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println("UN: " + userName);
		System.out.println("Password: " + password);
		
		// 1. Proveriti da li su userName i pass null ili prazni.
		boolean daLiSuUserIPassPrazni = service.proveriUserIPassPrazni(userName, password);
		
		if(daLiSuUserIPassPrazni) {
			// 1a. Ako je userName ili pass null ili prazan 
			//     vrati odgovor da mora da mora da popuni ta polja.
			response.sendRedirect("stranice/prazan_unos.html");
		}else {
			
			// 1.b. Ako nisu prazni ili null idemo dalje
			// 2. U bazi proveriti da li postoji user sa tim userName-om i pass-om.
			User user = service.vratiAkoPostojiUser(userName, password);
			if(user != null) {
				// 2b. Ako postoji user prebaciti ga na njegovu stranu.
				// Otvaramo sesiju
				HttpSession sesija = request.getSession();
				// "U kutiju ubacujemo objekat user i na kutiji pisemo user"
				sesija.setAttribute("user", user);
				if(user.getUserType() == UserType.ADMINISTRACIJA) {
					response.sendRedirect("view/admin.jsp");
				}else if(user.getUserType() == UserType.STUDENT) {
					response.sendRedirect("view/student.jsp");
				}else if (user.getUserType() == UserType.PROFESOR) {
					response.sendRedirect("view/profesor.jsp");
				}else {
					response.sendRedirect("stranice/loginError.html");
				}
				
			}else {
				// 2a. Ako ne postoji treba da vratimo odgovor da pokusa ponovo logovanje.
				response.sendRedirect("stranice/login.html");
			}
			
			
		}
		
		
		
		
		
		
		
	}

}
