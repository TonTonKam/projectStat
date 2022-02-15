package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ArticleDaoProj;
import controller.CategorieDao;
import controller.UserDaoProj;
import model.ArticleCl;
import model.User;

/**
 * Servlet implementation class CreationArticle
 */
@WebServlet("/creationArticle")
public class CreationArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDao cd = new CategorieDao();
	private ArticleDaoProj ad = new ArticleDaoProj();
	private UserDaoProj ud = new UserDaoProj();

    public CreationArticle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCategorie = Integer.parseInt(request.getParameter("categorie"));

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String categorie = request.getParameter("newCate");
		
		
		if(idCategorie == -1) {
			try {
				cd.ajoutCategorie(categorie);
				//String titre, String contenu, int idUser, int idCategorie
				ArticleCl article = new ArticleCl(request.getParameter("titre"), request.getParameter("contenu"), user.getIdUser(), ud.findById(user.getIdUser()), cd.findByName(categorie));
				ad.enregistrer(article, user.getIdUser());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			ArticleCl article = new ArticleCl(request.getParameter("titre"), request.getParameter("contenu"), user.getIdUser(), ud.findById(user.getIdUser()), idCategorie);
			ad.enregistrer(article, user.getIdUser());
		}
		
		response.sendRedirect("index");
	}
	
}
