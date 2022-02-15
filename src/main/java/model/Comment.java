package model;

import java.sql.Date;

public class Comment {

	//attributs
	private String contenu, auteur;
	private int idComment, idArticle, idUser;
	private Date date;
	private boolean isVisible;
	
	//constructor
	public Comment(String contenu, int idUser, String auteur, int idComment, int idArticle, Date date, boolean isVisible) {
		super();
		this.contenu = contenu;
		this.idUser = idUser;
		this.auteur = auteur;
		this.idComment = idComment;
		this.idArticle = idArticle;
		this.date = date;
		this.isVisible = isVisible;
	}
	
	public Comment(String contenu) {
		super();
		this.contenu = contenu;
	}
	

	//getter
	public String getContenu() {
		return contenu;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public int getIdComment() {
		return idComment;
	}
	
	public int getIdArticle() {
		return idArticle;
	}

	public Date getDate() {
		return date;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}
}
