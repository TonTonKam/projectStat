package model;

import java.sql.Date;

public class CommentAd {
	
	//attributs
	private String contenu, auteur, titre;
	private int idComment, idArticle, idUser;
	private Date date;
	private boolean isExiste;

	//constructor
	public CommentAd(String contenu, String auteur, String titre, int idComment, int idArticle, int idUser, Date date,
			boolean isExiste) {
		super();
		this.contenu = contenu;
		this.auteur = auteur;
		this.titre = titre;
		this.idComment = idComment;
		this.idArticle = idArticle;
		this.idUser = idUser;
		this.date = date;
		this.isExiste = isExiste;
	}


	//getter
	public String getContenu() {
		return contenu;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getTitre() {
		return titre;
	}

	public int getIdComment() {
		return idComment;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public int getIdUser() {
		return idUser;
	}

	public Date getDate() {
		return date;
	}

	public boolean isExiste() {
		return isExiste;
	}
	
}
