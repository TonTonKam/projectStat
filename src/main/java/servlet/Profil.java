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
import controller.CommentDao;
import model.ArticleCl;
import model.User;

/**
 * Servlet implementation class ListImages
 */
@WebServlet("/profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDaoProj ad = new ArticleDaoProj();
	private CommentDao cod = new CommentDao();
	private CategorieDao cd = new CategorieDao();
       
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessions = request.getSession();
		User user = null;
		user = (User) sessions.getAttribute("user");
		
		int paramId = Integer.parseInt(request.getParameter("id"));
		
		if(ad.afficherArtById(paramId) != null) {
			request.setAttribute("listArtUser", ad.afficherArtById(paramId));
		}
		
		if(cod.listCommentAccueil() != null) {
			request.setAttribute("listCom", cod.listComment());
		}
		
		if(cd.listCategories() != null) {
			request.setAttribute("listCate", cd.listCategories());
		}
		
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int inpIdCategorie = 0;
		int inpIdArticle = 0;
		String inpTitre = request.getParameter("inpTitre");
		String inpContenu = request.getParameter("inpCont");
		
		if(request.getParameter("selectCategorie") != null && request.getParameter("selectCategorie") != "" 
			&& request.getParameter("selectCategorie") != " ") {
			
			inpIdCategorie = Integer.parseInt(request.getParameter("selectCategorie"));
		}
		
		if(request.getParameter("inpIdArticle") != null && request.getParameter("inpIdArticle") != "" 
			&& request.getParameter("inpIdArticle") != " ") {
			
			inpIdArticle = Integer.parseInt(request.getParameter("inpIdArticle"));
		}
		
		String categorie = request.getParameter("newCate");
		
		HttpSession sessions = request.getSession();
		User user = null;
		user = (User) sessions.getAttribute("user");
		
		if(user != null ) {
			if(inpIdCategorie == -1) {
				try {
					//ajout de la categorie dans la bdd
					cd.ajoutCategorie(categorie);
					/*
					 * String titre, String contenu, int idCategorie, int idArticle, ArticleCl art
					 * on prend les valeurs des inputs, on prend l'article avec sa valeur pas default et
					 * on compare les changements avec les anciennes
					 */
					ad.gestObjArticle(inpTitre, inpContenu, cd.findByName(categorie), inpIdArticle, ad.returnArtById(inpIdArticle));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				ad.gestObjArticle(inpTitre, inpContenu, inpIdCategorie, inpIdArticle, ad.returnArtById(inpIdArticle));
			}
			
			response.sendRedirect("profil?id="+user.getIdUser());
		}

	}

}
