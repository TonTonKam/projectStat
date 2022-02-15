package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comment;
import model.GetConnection;

public class CommentDao {

	private Connection connect = GetConnection.getConnectionWindows();
	private UserDaoProj ud = new UserDaoProj();
	
	public void enregistrement(Comment comment, int idUser, int idArticle) {
		
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO `commentaire` "
				+"(`id_commentaire`, `id_user`, `id_article`, `contenu`, `date`, `isVisible`)"
				+" VALUES (NULL, ?, ?, ?, now(), '1')  ");
			
			req.setInt(1, idUser);
			req.setInt(2, idArticle);
			req.setString(3, comment.getContenu());
			
			req.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Comment> listComment() {
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM commentaire");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				//String contenu, String auteur, int idComment, int idArticle, Date date, boolean isVisible
				listComment.add(new Comment(rs.getString("contenu"), rs.getInt("id_user"), ud.findById(rs.getInt("id_user")),
					rs.getInt("id_commentaire"), rs.getInt("id_article"), rs.getDate("date"), rs.getBoolean("isVisible")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listComment;
	}
	
	public ArrayList<Comment> listCommentAccueil() {
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM commentaire WHERE isVisible = 1");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				//String contenu, String auteur, int idComment, int idArticle, Date date, boolean isVisible
				listComment.add(new Comment(rs.getString("contenu"), rs.getInt("id_user"), ud.findById(rs.getInt("id_user")),
					rs.getInt("id_commentaire"), rs.getInt("id_article"), rs.getDate("date"), rs.getBoolean("isVisible")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listComment;
	}
}
