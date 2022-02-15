package controllerAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ArticleDaoProj;
import controller.UserDaoProj;
import model.CommentAd;
import model.GetConnection;

public class CommentAdminDao implements Iadmin{

	private Connection connect = GetConnection.getConnectionWindows();
	private UserDaoProj ud = new UserDaoProj();
	private ArticleDaoProj ad = new ArticleDaoProj();
	
	public ArrayList<CommentAd> listCommentAd() {
		ArrayList<CommentAd> listCommentAd = new ArrayList<CommentAd>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT commentaire.*, utilisateur.nom, article.titre FROM commentaire INNER JOIN article ON article.id_article = commentaire.id_article INNER JOIN utilisateur ON utilisateur.id_user = commentaire.id_user");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				//String contenu, String auteur, String titre, int idComment, int idArticle, int idUser, Date date,	boolean isVisible
				listCommentAd.add(new CommentAd(rs.getString("contenu"), ud.findById(rs.getInt("id_user")), ad.findById(rs.getInt("id_article")),
					rs.getInt("id_commentaire"), rs.getInt("id_article"), rs.getInt("id_user"), rs.getDate("date"), rs.getBoolean("isVisible")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCommentAd;
	}

	public void changeVisible(int idComment) throws SQLException {
		boolean existe = false;
		
		PreparedStatement sql = connect.prepareStatement("SELECT isVisible FROM commentaire WHERE id_commentaire = ?");
		sql.setInt(1, idComment);
		
		ResultSet rs = sql.executeQuery();
		while(rs.next()) {
			existe = rs.getBoolean("isVisible");
		}
		System.out.println("L55 ArticleAdminDao visible : "+ existe);
		
		if(existe) {
			PreparedStatement req1 = connect.prepareStatement("UPDATE commentaire SET isVisible = false WHERE id_commentaire = ?");
			req1.setInt(1, idComment);
			
			req1.executeUpdate();
			
		}else {
			PreparedStatement req2 = connect.prepareStatement("UPDATE commentaire SET isVisible = true WHERE id_commentaire = ?");
			req2.setInt(1, idComment);
			
			req2.executeUpdate();
			
		}
		
	}
}
