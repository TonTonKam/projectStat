package controllerAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GetConnection;
import model.User;

public class UserAdminDao {
	
	private Connection connect = GetConnection.getConnectionWindows();

	public ArrayList<User> listUser(){
		ArrayList<User> listUser = new ArrayList<User>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM utilisateur");
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				listUser.add(new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"),
					rs.getInt("age"), rs.getString("civilite"), rs.getString("email"), rs.getString("password"),
					rs.getDate("dateInscription"), rs.getInt("id_status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUser;
	}
	
	public void delete(int idUser) {
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM utilisateur WHERE id_user = ?");
			req.setInt(1, idUser);
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
