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
 * Servlet implementation class editProfil
 */
@WebServlet("/editProfil")
public class EditProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoProj ud = new UserDaoProj();
	
       
    public EditProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		
		if(user != null) {
			user = ud.returnUserById(user.getIdUser());
			request.setAttribute("userProfil", user);
		}

		request.getRequestDispatcher("editProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		User user = null;
		user = (User) session.getAttribute("user");
		
		int idUser = 0;
		String nom = null;
		String prenom = null;
		String email = null;
		
		if(user != null) {
			idUser = user.getIdUser();
		}
		
		if(request.getParameter("prenomEdit") != null && request.getParameter("prenomEdit") != ""
				&& request.getParameter("prenomEdit") != " ") {
			nom = request.getParameter("prenomEdit");
		}
		
		if(request.getParameter("nomEdit") != null && request.getParameter("nomEdit") != ""
				&& request.getParameter("nomEdit") != " ") {
			prenom = request.getParameter("nomEdit");
		}
		
		if(request.getParameter("emailEdit") != null && request.getParameter("emailEdit") != ""
				&& request.getParameter("emailEdit") != " ") {
			email = request.getParameter("emailEdit");
		}
		
		ud.editProfil(nom, prenom, email, idUser);
		
		response.sendRedirect("profil?id="+idUser);
	}

}
