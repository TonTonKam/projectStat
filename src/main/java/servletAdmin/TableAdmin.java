package servletAdmin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerAdmin.ArticleAdminDao;
import controllerAdmin.CategorieAdminDao;
import controllerAdmin.CommentAdminDao;
import controllerAdmin.UserAdminDao;
import model.Categorie;

/**
 * Servlet implementation class TableAdmin
 */
@WebServlet("/admin/tableAdmin")
public class TableAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentAdminDao cad = new CommentAdminDao();
    private UserAdminDao uad = new UserAdminDao();
    private ArticleAdminDao aad = new ArticleAdminDao();
    private CategorieAdminDao catad = new CategorieAdminDao();

    public TableAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    //get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listCommentAd", cad.listCommentAd());
		request.setAttribute("listArticleAd", aad.listArticleAd());
		request.setAttribute("listUser", uad.listUser());
		request.setAttribute("listCategorie", catad.listCategorieAd());
		
		request.getRequestDispatcher("tableAdmin.jsp").forward(request, response);
	}

	//post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/********************** USER ADMIN *********************/
		
		System.out.println("L 49 TableAdmin value : " + request.getParameter("inputIdUserAdmin"));
		System.out.println("L 45 TableAdmin value : " + request.getParameter("inputUserNomAdmin"));
		System.out.println("L 46 TableAdmin value : " + request.getParameter("inputUserPrenomAdmin"));
		System.out.println("L 47 TableAdmin value : " + request.getParameter("inputUserAgeAdmin"));
		System.out.println("L 48 TableAdmin value : " + request.getParameter("inputUserCivAdmin"));
		System.out.println("L 49 TableAdmin value : " + request.getParameter("inputUserEmailAdmin"));
		System.out.println("L 50 TableAdmin value : " + request.getParameter("inputUserDateInscriptionAdmin"));
		System.out.println("L 56 TableAdmin value : " + request.getParameter("inputIdStatusUserAdmin"));

		if(request.getParameter("inputIdUserAdmin") != null && request.getParameter("inputIdUserAdmin") != "" 
				&& request.getParameter("inputIdUserAdmin") != " " ) {
			int idUSer = Integer.parseInt(request.getParameter("inputIdUserAdmin"));
			uad.delete(idUSer);
		}
		
		/********************** ARTICLE ADMIN ******************/
		
		System.out.println("L 66 TableAdmin value : " + request.getParameter("inputIdArticleAdmin"));
		System.out.println("L 62 TableAdmin value : " + request.getParameter("inputArtTitreAdmin"));
		System.out.println("L 63 TableAdmin value : " + request.getParameter("inputArtContenuAdmin"));
		System.out.println("L 64 TableAdmin value : " + request.getParameter("inputArtResumeAdmin"));
		System.out.println("L 65 TableAdmin value : " + request.getParameter("inputArtImageAdmin"));
		System.out.println("L 66 TableAdmin value : " + request.getParameter("inputArtIdUserAdmin"));
		System.out.println("L 67 TableAdmin value : " + request.getParameter("inputArtAuteurAdmin"));
		System.out.println("L 68 TableAdmin value : " + request.getParameter("inputArtIdCateAdmin"));
		System.out.println("L 69 TableAdmin value : " + request.getParameter("inputArtLibelleAdmin"));
		System.out.println("L 70 TableAdmin value : " + request.getParameter("inputArtVueAdmin"));
		System.out.println("L 71 TableAdmin value : " + request.getParameter("inputArtSignePosiAdmin"));
		System.out.println("L 72 TableAdmin value : " + request.getParameter("inputArtSigneNegAdmin"));
		System.out.println("L 78 TableAdmin value : " + request.getParameter("inputArtExisteAdmin"));
		
		if(request.getParameter("inputIdArticleAdmin") != null && request.getParameter("inputIdArticleAdmin") != "" 
				&& request.getParameter("inputIdArticleAdmin") != " " ) {
			
			int idArticle = Integer.parseInt(request.getParameter("inputIdArticleAdmin"));
			
			try {
				aad.changeVisible(idArticle);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/********************** COMMENTAIRE ADMIN ******************/
		
		System.out.println("L 95 TableAdmin value : " + request.getParameter("inputIdCommentAdmin"));
		System.out.println("L 96 TableAdmin value : " + request.getParameter("inputCommentContenuAdmin"));
		System.out.println("L 97 TableAdmin value : " + request.getParameter("inputCommentDateAdmin"));
		System.out.println("L 98 TableAdmin value : " + request.getParameter("inputCommentIdUserAdmin"));
		System.out.println("L 99 TableAdmin value : " + request.getParameter("inputCommentAuteurAdmin"));
		System.out.println("L 100 TableAdmin value : " + request.getParameter("inputCommentIdArticleAdmin"));
		System.out.println("L 101 TableAdmin value : " + request.getParameter("inputCommentTitreAdmin"));
		System.out.println("L 102 TableAdmin value : " + request.getParameter("inputCommentExisteAdmin"));
		
		if(request.getParameter("inputIdCommentAdmin") != null && request.getParameter("inputIdCommentAdmin") != "" 
				&& request.getParameter("inputIdCommentAdmin") != " " ) {
			
			int idComment = Integer.parseInt(request.getParameter("inputIdCommentAdmin"));
			
			try {
				cad.changeVisible(idComment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/********************** CATEGORIE ADMIN ******************/
		
		System.out.println("L 120 TableAdmin value : " + request.getParameter("inputIdCategorieAdmin"));
		System.out.println("L 122 TableAdmin value : " + request.getParameter("inputcaCateLibelleAdmin"));
		
		//prend la valeur de la modification 
		int idCategorie = Integer.parseInt(request.getParameter("inputIdCategorieAdmin"));
		
		String libelleCate = request.getParameter("inputCateLibelleAdmin");
		Categorie cate = null;
		
		if(request.getParameter("inputCateLibelleAdmin") == null) {
			catad.delete(idCategorie);
		}else {
			
			cate = catad.returnCateById(idCategorie);

			if(cate != null) {
				catad.modificationCategorie(idCategorie, libelleCate, cate);				
			}
		}
		
		response.sendRedirect("tableAdmin");
	}

}
