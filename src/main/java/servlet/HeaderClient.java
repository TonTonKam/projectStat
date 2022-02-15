package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserDaoProj;
import model.User;

/**
 * Servlet implementation class HeaderClient
 */
@WebServlet("/headerClient")
public class HeaderClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoProj ud = new UserDaoProj();

    public HeaderClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inscription
		/*
		 * faire une verif sur les champs avec js
		 */
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		//int age = request.getParameter("age");
//		String civ = request.getParameter("optradio");
		
		//String nom, String prenom, int age, String civilite, String email, String password
		if(prenom != null && nom != null && email != null && pwd != null) {
			
			User user = new User(nom, prenom, email, pwd);
			
			ud.enregistrer(user);
			response.sendRedirect("index");
		}
		
		
		//login
		String loginM = request.getParameter("loginEmail");
		String loginP = request.getParameter("loginPassword");
		
		if(loginM != null && loginP != null) {
			HttpSession session = request.getSession();
			User user;
			user = ud.usedUser(loginM, loginP);
			session.setAttribute("user", user);
			
			if(user.getIdStatus() == 1) {
				response.sendRedirect("index");
			}else if (user.getIdStatus() == 2) {
				response.sendRedirect("admin/indexAdmin");
			}
			
		}
		
	}

}
