package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categorie;
import model.GetConnection;

public class CategorieDao {
	
	private Connection connect = GetConnection.getConnectionWindows();

	public ArrayList<Categorie> listCategories() {
		ArrayList<Categorie> listCategorie = new ArrayList<Categorie>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM categorie");
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				listCategorie.add(new Categorie(rs.getInt("id_categorie"), rs.getString("libelle")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCategorie;
	}
	
	public void ajoutCategorie(String cate) throws SQLException {
		
		PreparedStatement req = connect.prepareStatement("INSERT INTO `categorie` (`id_categorie`, `libelle`) VALUES (NULL, ?) ");
		req.setString(1, cate);
		req.executeUpdate();
	}
	
	public int findByName(String cate) {
		int result = 0;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_categorie FROM categorie WHERE libelle = ?");
			sql.setString(1, cate);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				result = rs.getInt("id_categorie");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
