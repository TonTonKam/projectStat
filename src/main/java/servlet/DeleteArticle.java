package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ArticleDaoProj;

/**
 * Servlet implementation class DeleteArticle
 */
@WebServlet("/delArt")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDaoProj ad = new ArticleDaoProj();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle = Integer.parseInt(request.getParameter("idArt"));
		ad.delete(idArticle);
		response.sendRedirect("index");
	}

}
