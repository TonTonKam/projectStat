package controllerAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categorie;
import model.GetConnection;

public class CategorieAdminDao {
	
	private Connection connect = GetConnection.getConnectionWindows();

	public ArrayList<Categorie> listCategorieAd() {
		ArrayList<Categorie> listCategorie = new ArrayList<Categorie>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM categorie ");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				//String contenu, String auteur, String titre, int idComment, int idArticle, int idUser, Date date,	boolean isVisible
				listCategorie.add(new Categorie(rs.getInt("id_categorie"), rs.getString("libelle")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCategorie;
	}

	public void delete(int idCategorie) {
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM categorie WHERE id_categorie = ?");
			req.setInt(1, idCategorie);
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void modifier(Categorie categorie, int idCategorie) {
		
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE categorie SET id_categorie = ? , libelle = ? WHERE id_categorie = ?");
			req.setInt(1, categorie.getIdCategorie());
			req.setString(2, categorie.getLibelle());
			req.setInt(3, idCategorie);
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificationCategorie(int inputIdCategorie, String inputLibelle, Categorie categorie) {
		int inputIdC = inputIdCategorie;
		String inputLib = inputLibelle;
		
		if(inputIdC == 0) {
			inputIdC = categorie.getIdCategorie();
		}
		
		if(inputLib == null || inputLib == "" || inputLib == " ") {
			inputLib = categorie.getLibelle();
		}
		
		Categorie newCategorie = new Categorie(inputIdC, inputLib);
		modifier(newCategorie, inputIdC);
	}
	
	public Categorie returnCateById(int idCategorie) {
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM categorie WHERE id_categorie = ?");
			sql.setInt(1, idCategorie);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				return new Categorie(rs.getInt("id_categorie"), rs.getString("libelle"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
