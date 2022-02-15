package model;

import java.sql.Date;

public class ArticleAd {
	
	//attributs
	private String titre, contenu, resume, image, auteur, libelle;
	private int idArticle, idUser, idCategorie, idVue, idSigne;
	private Date date;
	private boolean isExiste;
	
	//constructeur
	public ArticleAd(String titre, String contenu, String resume, String image, String auteur, String libelle,
			int idArticle, int idUser, int idCategorie, int idVue, int idSigne, Date date,
			boolean isExiste) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.resume = resume;
		this.image = image;
		this.auteur = auteur;
		this.libelle = libelle;
		this.idArticle = idArticle;
		this.idUser = idUser;
		this.idCategorie = idCategorie;
		this.idVue = idVue;
		this.idSigne = idSigne;
		this.date = date;
		this.isExiste = isExiste;
	}

	//getter
	public String getTitre() {
		return titre;
	}

	public String getContenu() {
		return contenu;
	}

	public String getResume() {
		return resume;
	}

	public String getImage() {
		return image;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public int getIdUser() {
		return idUser;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public int getIdVue() {
		return idVue;
	}

	public int getIdSigne() {
		return idSigne;
	}

	public Date getDate() {
		return date;
	}

	public boolean isExiste() {
		return isExiste;
	}
	
}
