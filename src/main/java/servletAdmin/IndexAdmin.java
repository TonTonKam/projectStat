package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class IndexAdmin
 */
@WebServlet("/admin/indexAdmin")
public class IndexAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("../index");
		}else {
			if(user.getIdStatus() == 2) {
				request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
			}else {
				response.sendRedirect("../index");
			}
		}
		
	}


}
