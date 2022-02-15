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
 * Servlet implementation class EditPassword
 */
@WebServlet("/editPassword")
public class EditPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoProj ud = new UserDaoProj();
       
    public EditPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		
		request.getRequestDispatcher("editPassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		
		String pwd = null;
		String pwdConf = null;
		
		if(request.getParameter("passwordEdit") != null && request.getParameter("passwordEdit") != "" 
				&& request.getParameter("passwordEdit") != " ") {
			pwd = request.getParameter("passwordEdit");
		}
		
		if(request.getParameter("passwordConfEdit") != null && request.getParameter("passwordConfEdit") != "" 
				&& request.getParameter("passwordConfEdit") != " ") {
			pwdConf = request.getParameter("passwordConfEdit");
		}
		
		if(user != null) {
			ud.changerPwd(pwd, pwdConf, user.getIdUser());
		}
		
		response.sendRedirect("profil?id="+ user.getIdUser());
	}

}
