package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import model.GetConnection;
import model.User;

public class UserDaoProj{

	private Connection connect = GetConnection.getConnectionWindows();

	public void enregistrer(User object) {
		
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO `utilisateur` (`id_user`, `id_status`, `nom`, `prenom`, `age`, `civilite`, `email`, `password`, `dateInscription`) VALUES"
					+"(NULL, '1', ?, ?, NULL, NULL, ?, ?, now())");
			
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getEmail());
			try {
				req.setString(4, encode(object.getPassword()));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User usedUser(String email, String pwd) {
		
		User user = null;
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?");
			sql.setString(1, email);
			try {
				sql.setString(2, encode(pwd));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				if(rs.getString("nom") != null && rs.getInt("id_user") != 0) {
					user = new User(rs.getString("nom"), rs.getInt("id_user"), rs.getInt("id_status"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public String findById(int idUser) {
		
		String name = null;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT nom FROM utilisateur WHERE id_user = ?");
			sql.setInt(1, idUser);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				name = rs.getString("nom");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public User returnUserById(int idUser) {
		User user = null;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM utilisateur WHERE id_user = ?");
			sql.setInt(1, idUser);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				user = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	private void modifProfil(User user, int idUser) {
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE `utilisateur` SET `nom` = ?, `prenom` = ?, `email` = ? WHERE `utilisateur`.`id_user` = ? ");
			req.setString(1, user.getNom());
			req.setString(2, user.getPrenom());
			req.setString(3, user.getEmail());
			req.setInt(4, idUser);
			
			req.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editProfil(String editNom, String editPrenom, String editEmail, int idUser) {
		User userDefault = returnUserById(idUser);
		
		if(editNom == null) {
			editNom = userDefault.getNom();
		}
		
		if(editPrenom == null) {
			editPrenom = userDefault.getPrenom();
		}
		
		if(editEmail == null) {
			editEmail = userDefault.getEmail();
		}
		
		User newUser = new User(editNom, editPrenom, editEmail);
		modifProfil(newUser, idUser);
		
	}
	
	public void changerPwd(String newPwd, String confirmPwd, int idUser) {
		String pwd = null;
		
		if(newPwd.equals(confirmPwd)) {
			pwd = newPwd;
		}
		
		//on verifie que la valeur du nouveau mot de passe ne soit pas vide
		if(pwd != null && pwd != "" && pwd != " ") {
			try {
				PreparedStatement req = connect.prepareStatement("UPDATE utilisateur SET password = ? WHERE utilisateur.id_user = ?");
				
				try {
					req.setString(1, encode(pwd));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setInt(2, idUser);
				
				req.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int idByEmail(String email) {
		int idUser = 0;
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_user FROM utilisateur WHERE email = ?");
			sql.setString(1, email);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				idUser = rs.getInt("id_user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idUser;
	}
	
	// CRYPTAGE DU PWD
	public static String encode(String value) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
	
		return encoded;

	}
}
