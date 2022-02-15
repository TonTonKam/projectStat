package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ArticleCl;
import model.GetConnection;


public class ArticleDaoProj {

	private Connection connect = GetConnection.getConnectionWindows();
	private UserDaoProj ud = new UserDaoProj();
	
	public void enregistrer(ArticleCl article, int idUser) {
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO `article` "
				+"(`id_article`, `id_user`, `id_categorie`, `titre`, `date`, `contenu`, `resume`, `image`, `id_vue`, `id_signe`,`isVisible`) VALUES "
				+"(NULL, ?, ?, ?, now(), ?, NULL, NULL, '0', '0', '1') ");
			req.setInt(1, idUser);
			req.setInt(2, article.getIdCategorie());
			req.setString(3, article.getTitre());
			req.setString(4, article.getContenu());
//			req.setString(5, article.getResume());
//			req.setString(6, article.getImage());
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ArticleCl> afficherArticles() {
		//categorie affiche les articles
		ArrayList<ArticleCl> listArticle = new ArrayList<ArticleCl>();
		
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("SELECT article.*, categorie.libelle AS libelle FROM article INNER JOIN categorie ON article.id_categorie = categorie.id_categorie");
		
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				/* String titre, String contenu, String resume, String image, int idSigne, int idArticle, int idUser, String auteur,
				 *  int idCategorie, String libelle, int idVue,	Date date, boolean isVisible */
				listArticle.add(new ArticleCl(rs.getString("titre"), rs.getString("contenu"), rs.getString("resume"), rs.getString("image"),
					rs.getInt("id_signe"), rs.getInt("id_article"), rs.getInt("id_user"),
					ud.findById(rs.getInt("id_user")), rs.getInt("id_Categorie"), rs.getString("libelle"), rs.getInt("id_vue"),
					rs.getDate("date"), rs.getBoolean("isVisible")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArticle;
	}
	
	public ArrayList<ArticleCl> afficherArticlesAccueil() {
		//categorie affiche les articles
		ArrayList<ArticleCl> listArticle = new ArrayList<ArticleCl>();
		
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("SELECT article.*, categorie.libelle AS libelle FROM article INNER JOIN categorie ON article.id_categorie = categorie.id_categorie WHERE isVisible = 1");
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				/* String titre, String contenu, String resume, String image, String signePositif, String signeNegatif,
				int idArticle, int idUser, int idCategorie, int vues, Date date, boolean isVisible */
				listArticle.add(new ArticleCl(rs.getString("titre"), rs.getString("contenu"), rs.getString("resume") ,rs.getString("image"),
					rs.getInt("id_signe"), rs.getInt("id_article"), rs.getInt("id_user"), ud.findById(rs.getInt("id_user")), rs.getInt("id_Categorie"), 
					rs.getString("libelle"), rs.getInt("id_vue"), rs.getDate("date"), rs.getBoolean("isVisible")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArticle;
	}
	
	public ArrayList<ArticleCl> afficherArticlesDeCategorie(int categorie) {
		//categorie affiche les articles
		ArrayList<ArticleCl> listArticle = new ArrayList<ArticleCl>();
		
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("SELECT article.*, categorie.libelle AS libelle FROM article INNER JOIN categorie ON article.id_categorie = categorie.id_categorie WHERE article.id_categorie = ?");
			sql.setInt(1, categorie);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				/* String titre, String contenu, String image, String auteur, String signePositif,
				 * String signeNegatif, int id_article, int vues, Date date, boolean isVisible */
				ArticleCl article = new ArticleCl(rs.getString("titre"), rs.getString("contenu"), rs.getString("resume") ,rs.getString("image"),
					rs.getInt("id_signe"), rs.getInt("id_article"), rs.getInt("id_user"), ud.findById(rs.getInt("id_user")),
					rs.getInt("id_Categorie"), rs.getString("libelle"), rs.getInt("id_vue"), rs.getDate("date"), rs.getBoolean("isVisible"));
				listArticle.add(article);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArticle;
	}
	
	public ArrayList<ArticleCl> afficherArtById(int idUser){
		ArrayList <ArticleCl> listArtByUser = new ArrayList<ArticleCl>();
		
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("SELECT article.*, categorie.libelle AS libelle FROM article INNER JOIN categorie ON article.id_categorie = categorie.id_categorie WHERE id_user = ?");
			sql.setInt(1, idUser);
		
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				listArtByUser.add(new ArticleCl(rs.getString("titre"), rs.getString("contenu"), rs.getString("resume") ,rs.getString("image"),
					rs.getInt("id_signe"), rs.getInt("id_article"), rs.getInt("id_user"), ud.findById(rs.getInt("id_user")),
					rs.getInt("id_Categorie"), rs.getString("libelle"), rs.getInt("id_vue"), rs.getDate("date"), rs.getBoolean("isVisible")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listArtByUser;
	}
	
	public String findById(int idArticle) {
		
		String titre = null;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT titre FROM article WHERE id_article = ?");
			sql.setInt(1, idArticle);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				titre = rs.getString("titre");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return titre;
	}
	
	//associer a la fonction gestObjArticle
	public ArticleCl returnArtById(int idArticle) {
		
		ArticleCl art = null;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article WHERE id_article = ?");
			sql.setInt(1, idArticle);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				//String inputTitre, String inputContenu, int inputIdCategorie
				art = new ArticleCl(rs.getString("titre"), rs.getString("contenu"), rs.getString("image"), rs.getInt("id_categorie"), rs.getInt("id_article"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return art;
	}
	
	//associer a la fonction gestObjArticle
	private void modifier(ArticleCl article) {
		
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE `article` SET `id_categorie` = ?, `titre` = ?, `contenu` = ? WHERE `article`.`id_article` = ? ");
			req.setInt(1, article.getIdCategorie());
			req.setString(2, article.getTitre());
			req.setString(3, article.getContenu());
			req.setInt(4, article.getIdArticle());
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gestObjArticle(String inputTitre, String inputContenu, int inputIdCategorie,
		int idArticle, ArticleCl article) {
		
		String inputT = inputTitre;
		String inputC = inputContenu;
		int inputIdC = inputIdCategorie;
		
		if(inputT == null || inputT == "" || inputT == " ") {
			inputT = article.getTitre();
		}
		
		if(inputC == null || inputC == "" || inputC == " ") {
			inputC = article.getContenu();
		}
		
		if(inputIdC == 0) {
			inputIdC = article.getIdCategorie();
		}
		
		//recupere ancienne date et isVisibe
		ArticleCl ajoutArt = new ArticleCl(inputT, inputC, null, inputIdC, idArticle);
		modifier(ajoutArt);
		
	}
	
	public void delete(int idArticle) {
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE article SET isVisible = 0 WHERE article.id_article = ?");
			req.setInt(1, idArticle);
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
