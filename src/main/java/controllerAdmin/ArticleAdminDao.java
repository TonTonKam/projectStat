package controllerAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.UserDaoProj;
import model.ArticleAd;
import model.GetConnection;

public class ArticleAdminDao implements Iadmin{
	
	private Connection connect = GetConnection.getConnectionWindows();
	private UserDaoProj ud = new UserDaoProj();
	
	public ArrayList<ArticleAd> listArticleAd(){
		ArrayList<ArticleAd> listArticleAd = new ArrayList<ArticleAd>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT article.*, utilisateur.nom, categorie.libelle FROM article INNER JOIN utilisateur ON utilisateur.id_user = article.id_user INNER JOIN categorie ON categorie.id_categorie = article.id_categorie");
			
			ResultSet rs = sql.executeQuery();
			/*
			 * String titre, String contenu, String resume, String image, String auteur, String nomCate,
			int idArticle, int idUser, int idCategorie, int idVue, int idSigne, Date date, boolean isVisible
			 */
			while(rs.next()) {
				listArticleAd.add(new ArticleAd(rs.getString("titre"), rs.getString("contenu"), rs.getString("resume"),
					rs.getString("image"), ud.findById(rs.getInt("id_user")), rs.getString("libelle"), rs.getInt("id_article"),
					rs.getInt("id_user"), rs.getInt("id_categorie"), rs.getInt("id_vue"), rs.getInt("id_signe"), rs.getDate("date"),
					rs.getBoolean("isVisible")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArticleAd;
	}
	
	public void changeVisible(int idArticle) throws SQLException {
		boolean existe = false;
		
		PreparedStatement sql = connect.prepareStatement("SELECT isVisible FROM article WHERE id_article = ?");
		sql.setInt(1, idArticle);
		
		ResultSet rs = sql.executeQuery();
		while(rs.next()) {
			existe = rs.getBoolean("isVisible");
		}
		
		if(existe) {
			PreparedStatement req1 = connect.prepareStatement("UPDATE article SET isVisible = false WHERE id_article = ?");
			req1.setInt(1, idArticle);
			
			req1.executeUpdate();
			
		}else {
			PreparedStatement req2 = connect.prepareStatement("UPDATE article SET isVisible = true WHERE id_article = ?");
			req2.setInt(1, idArticle);
			
			req2.executeUpdate();
			
		}
	}

	
}
