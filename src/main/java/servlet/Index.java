package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ArticleDaoProj;
import controller.CategorieDao;
import controller.CommentDao;
import model.Comment;
import model.User;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDao cd = new CategorieDao();
	private ArticleDaoProj ad = new ArticleDaoProj();
	private CommentDao cod = new CommentDao();
    
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(cd.listCategories() != null) {
			request.setAttribute("listCate", cd.listCategories());
		}

		if(request.getParameter("cate") == null) {
			if(ad.afficherArticlesAccueil() != null) {
				request.setAttribute("listArt", ad.afficherArticlesAccueil());
			}
		}else {
			int idCate = Integer.parseInt(request.getParameter("cate"));
			if(ad.afficherArticlesDeCategorie(idCate) != null) {
				request.setAttribute("listArt", ad.afficherArticlesDeCategorie(idCate));
			}
		}
		
		if(cod.listCommentAccueil() != null) {
			request.setAttribute("listCom", cod.listComment());
		}
		
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		
		Comment comment = new Comment(request.getParameter("comment"));
		int idArticle = Integer.parseInt(request.getParameter("idArt"));
		
		if(user != null) {
			cod.enregistrement(comment, user.getIdUser(), idArticle);
		}
		
		response.sendRedirect("index");
	}

}
